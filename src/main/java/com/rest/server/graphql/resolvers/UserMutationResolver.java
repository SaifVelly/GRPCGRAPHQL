package com.rest.server.graphql.resolvers;

import com.rest.server.models.User;
import com.rest.server.graphql.inputs.UserInput;
import com.rest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class UserMutationResolver {

    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument UserInput input) {
        User user = new User();
        user.setUserTitle(input.getUserTitle());
        user.setUserFirstName(input.getUserFirstName());
        user.setUserLastName(input.getUserLastName());
        user.setUserGender(input.getUserGender());
        user.setUserEmail(input.getUserEmail());
        user.setUserPassword(input.getUserPassword());
        user.setUserDateOfBirth(input.getUserDateOfBirth());
        user.setUserRegisterDate(Instant.now().toString());
        user.setUserPhone(input.getUserPhone());
        user.setUserPicture(input.getUserPicture());
        user.setUserLocationId(input.getUserLocationId());

        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument UserInput input) {
        User user = new User();
        user.setUserTitle(input.getUserTitle());
        user.setUserFirstName(input.getUserFirstName());
        user.setUserLastName(input.getUserLastName());
        user.setUserGender(input.getUserGender());
        user.setUserEmail(input.getUserEmail());
        user.setUserPassword(input.getUserPassword());
        user.setUserDateOfBirth(input.getUserDateOfBirth());
        user.setUserPhone(input.getUserPhone());
        user.setUserPicture(input.getUserPicture());
        user.setUserLocationId(input.getUserLocationId());
        user.setUserRegisterDate(Instant.now().toString());

        return userService.updateUser(id, user);
    }

    @MutationMapping
    public String deleteUser(@Argument String id) {
        userService.deleteUser(id);
        return id;
    }
}
