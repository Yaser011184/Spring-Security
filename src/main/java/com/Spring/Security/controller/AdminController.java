package com.Spring.Security.controller;

import com.Spring.Security.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userServiceImpl.getUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" )  Integer id,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userServiceImpl.deleteUserById(id);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  getUser(@PathVariable("userId") Integer id, Model model) {
        model.addAttribute("allUsers", userServiceImpl.findUserById(id));
        return "admin";
    }
}
