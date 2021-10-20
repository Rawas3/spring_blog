package com.example.site.blog.controllers;

import com.example.site.blog.models.Role;
import com.example.site.blog.models.User;
import com.example.site.blog.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/userlist")
/*@PreAuthorize("hasAuthority('ADMIN')")*/
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

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.saveUser(user);
        return "redirect:/userlist";
    }
}
