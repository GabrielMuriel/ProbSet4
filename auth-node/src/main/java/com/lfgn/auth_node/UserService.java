package com.example.authnode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Dummy user for demonstration
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";  // Encrypted password should be used in real applications

    public String authenticate(String username, String password) {
        if (USERNAME.equals(username) && passwordEncoder.matches(password, PASSWORD)) {
            return jwtUtil.generateToken(username);  // Generate and return JWT token if authentication is successful
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
