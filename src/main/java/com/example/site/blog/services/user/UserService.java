package com.example.site.blog.services.user;

import com.example.site.blog.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAllUsers();

    User findByUsername(String username);

    void deleteUser(Long id);
}
