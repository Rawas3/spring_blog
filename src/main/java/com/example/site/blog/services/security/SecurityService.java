package com.example.site.blog.services.security;

public interface SecurityService {

    String findLoggedUser();

    void autoLogin(String username, String password);
}
