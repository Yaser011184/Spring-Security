package com.Spring.Security.controller;

import com.Spring.Security.model.User;
import org.springframework.web.bind.annotation.*;
import com.Spring.Security.service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public List<User> userList() {
       List<User> allUsers = userService.getUsers();
        return allUsers;
    }

    @GetMapping("/admin/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        Optional<User> user = userService.findUserById(id);
        return user;
    }
    @PostMapping("/admin")
    public User addUser (@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/admin")
    public User updateUser (@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return "User with ID = " + id + " was deleted";
    }
}
