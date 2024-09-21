package com.Spring.Security.controller;

import com.Spring.Security.model.User;
import com.Spring.Security.service.UserService;
import com.Spring.Security.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public String userInfo(Principal principal) {
        User user = userServiceImpl.findByUsername(principal.getName());
        return user.getUsername() + " " + user.getEmail();
    }
}