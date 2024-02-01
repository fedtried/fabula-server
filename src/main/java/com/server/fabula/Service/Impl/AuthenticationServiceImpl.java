package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.Request.SignInRequest;
import com.server.fabula.Model.Request.SignUpRequest;
import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Model.Response.JwtAuthenticationResponse;
import com.server.fabula.Model.Role;
import com.server.fabula.Model.User;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.AuthenticationService;
import com.server.fabula.Service.JwtService;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ConversionService conversionService;

    public AuthenticationServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager,
            ConversionService conversionService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.conversionService = conversionService;
    }

    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        var user =
                UserEntity.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.USER)
                        .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).id(user.getId()).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user =
                userRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow(
                                () -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).id(user.getId()).build();
    }

    @Override
    public User updateUser(UpdateUserRequest userRequest) {
        UserEntity user =
                userRepository
                        .findById(userRequest.getId())
                        .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the provided current password matches the stored password
        if (userRequest.getCurrentPassword() != null
                && !userRequest.getCurrentPassword().isEmpty()
                && !passwordEncoder.matches(
                        userRequest.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException(
                    "Invalid current password for security verification");
        }

        // Update other fields
        if (!user.getName().equals(userRequest.getName())) {
            user.setName(userRequest.getName());
        }
        if (!user.getEmail().equals(userRequest.getEmail())) {
            user.setEmail(userRequest.getEmail());
        }

        if (userRequest.getNewPassword() != null && !userRequest.getNewPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequest.getNewPassword()));
        }

        userRepository.save(user);

        return conversionService.convert(user, User.class);
    }
}
