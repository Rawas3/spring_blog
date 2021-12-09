package com.example.site.blog.controllers;

import com.example.site.blog.models.Role;
import com.example.site.blog.models.User;
import com.example.site.blog.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String userLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "10-security/page-login";
    }

    @PostMapping("/registration")
    public String userAdd(Model model, @Valid User user, BindingResult bindingResult) {
        User userFromDb = userService.findByUsername(user.getUsername());

        if (bindingResult.hasErrors()) {
            return "10-security/page-login";
        } else if (userFromDb != null) {
            model.addAttribute("message", "User exist!");
            return "10-security/page-login";
        }
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/userlist")
    public String userListForm(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "7-user/page-userList";
    }

    @GetMapping("/userlist/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "7-user/page-userEdit";
    }

    @PostMapping("/userlist")
    public String userEdit(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {

        userService.saveUser(user, username, form);
        return "redirect:/userlist";
    }

    @RequestMapping("/userlist/{id}/remove")
    public String userDelete(@PathVariable(value = "id") long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/userlist";
    }
}
