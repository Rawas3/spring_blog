package com.example.site.blog.controllers;

import com.example.site.blog.models.Role;
import com.example.site.blog.models.User;
import com.example.site.blog.repository.UserRepository;
import com.example.site.blog.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    private String userList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user/user_list";
    }

    @GetMapping("{user}")
    private String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user/user_edit";
    }
}
