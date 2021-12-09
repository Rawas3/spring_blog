package com.example.site.blog.services.user;

import com.example.site.blog.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void addUser(User user);

    void saveUser(User user, String username, Map<String, String> form);

    List<User> findAllUsers();

    User findByUsername(String username);

    /*User findById(Long id);*/

    void deleteUser(Long id);
}
