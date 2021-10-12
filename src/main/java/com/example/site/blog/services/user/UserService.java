package com.example.site.blog.services.user;

import com.example.site.blog.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findAllUsers();

    User findByUsername(String username);
}
