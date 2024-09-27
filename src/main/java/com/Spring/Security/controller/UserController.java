package com.Spring.Security.controller;

import com.Spring.Security.model.User;
import com.Spring.Security.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User userInfo(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user;
    }
}