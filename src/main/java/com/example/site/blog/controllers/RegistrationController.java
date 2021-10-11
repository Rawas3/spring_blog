package com.example.site.blog.controllers;

import com.example.site.blog.models.Role;
import com.example.site.blog.models.User;
import com.example.site.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;


@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepository userRepository;
    /*private final PasswordEncoder passwordEncoder;*/

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "security/login";
    }

    @PostMapping
    public String addUser(Model model, @Valid User user, BindingResult bindingResult) {

        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (bindingResult.hasErrors()) {
            return "security/login";
        } else if (userFromDb != null) {
            model.addAttribute("message", "User exist!");
            return "security/login";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        /*user.setPassword(passwordEncoder.encode(user.getPassword()));*/

        return "redirect:/security/login";

    }
}
