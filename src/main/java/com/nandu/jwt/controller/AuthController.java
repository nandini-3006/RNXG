package com.nandu.jwt.controller;

import com.nandu.jwt.model.User;
import com.nandu.jwt.repository.UserRepository;
import com.nandu.jwt.security.JWTUtil;
import com.nandu.jwt.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userRepository.save(user);
        log.info("User '{}' registered successfully", request.getUsername());
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            String token = jwtUtil.generateToken(user.getUsername());
            log.info("User '{}' logged in successfully. Token issued.", user.getUsername());
            return token;
        } catch (AuthenticationException e) {
            log.error("Authentication failed for user: {}", user.getUsername(), e);
            return "Invalid username or password";
        }
    }
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from secured endpoint!";
    }

}
