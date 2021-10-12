package com.example.site.blog.services.user;

import com.example.site.blog.models.Role;
import com.example.site.blog.models.User;

import com.example.site.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
/*    private final BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
