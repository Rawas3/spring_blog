package com.example.site.blog.controllers;

import com.example.site.blog.models.User;
import com.example.site.blog.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/login")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "security/login";
    }

    @PostMapping("/registration")
    public String registerUser(Model model, @Valid User user, BindingResult bindingResult) {

        User userFromDb = userService.findByUsername(user.getUsername());

        if (bindingResult.hasErrors()) {
            return "security/login";
        } else if (userFromDb != null) {
            model.addAttribute("message", "User exist!");
            return "security/login";
        }
        userService.addUser(user);

        return "redirect:/security/login";
    }
}
