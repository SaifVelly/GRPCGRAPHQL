package com.rest.server.graphql.resolvers;

import com.rest.server.graphql.inputs.LoginInput;
import com.rest.server.graphql.responses.LoginResponse;
import com.rest.server.models.User;
import com.rest.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class AuthMutationResolver {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MutationMapping
    public LoginResponse login(@Argument LoginInput input) {
        return userRepository.findByUserEmail(input.getUserEmail())
                .filter(user -> passwordEncoder.matches(input.getUserPassword(), user.getUserPassword()))
                .map(user -> new LoginResponse(user.getUserId(), "User authenticated successfully"))
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }
}
