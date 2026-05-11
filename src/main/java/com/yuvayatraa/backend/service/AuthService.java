package com.yuvayatraa.backend.service;

import com.yuvayatraa.backend.dto.*;
import com.yuvayatraa.backend.entity.LoginActivity;
import com.yuvayatraa.backend.entity.User;
import com.yuvayatraa.backend.repository.LoginActivityRepository;
import com.yuvayatraa.backend.repository.UserRepository;
import com.yuvayatraa.backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final LoginActivityRepository loginActivityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.valueOf(request.getRole().toUpperCase()))
                .build();

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token, user.getRole().name(),
                user.getName(), user.getEmail(), "Registration successful!");
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        // Save login activity
        LoginActivity activity = LoginActivity.builder()
                .user(user)
                .role(user.getRole().name())
                .build();
        loginActivityRepository.save(activity);

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

        return new AuthResponse(token, user.getRole().name(),
                user.getName(), user.getEmail(), "Login successful!");
    }
}