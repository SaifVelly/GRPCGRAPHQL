package com.rest.server.graphql.resolvers;

import com.rest.server.models.User;
import com.rest.server.graphql.inputss.UserPage;
import com.rest.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserQueryResolver {

    @Autowired
    private UserService userService;

    @QueryMapping
    public UserPage getAllUsers(@Argument int page, @Argument int size) {
        Page<User> users = userService.allUsers(PageRequest.of(page, size));
        return new UserPage(users.getContent(), users.getTotalElements(), page, size);
    }

    @QueryMapping
    public User getUser(@Argument String id) {
        return userService.singleUser(id).orElse(null);
    }

    @QueryMapping
    public UserPage searchUsers(@Argument String query, @Argument int page, @Argument int size) {
        Page<User> users = userService.searchUsers(query, PageRequest.of(page, size));
        return new UserPage(users.getContent(), users.getTotalElements(), page, size);
    }
}
