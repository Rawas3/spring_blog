package com.example.site.blog;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderTest {

    @Test
    public void testEncodePassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPassword = "aaa";
        String encodedPassword = passwordEncoder.encode(testPassword);
        System.out.println("Encoded password: " + encodedPassword);

        boolean matched = passwordEncoder.matches("aaa", encodedPassword);

        assertTrue(matched);
    }
}
