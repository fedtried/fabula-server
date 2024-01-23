package com.server.fabula.Service.Impl;

import com.server.fabula.DAO.Request.SignInRequest;
import com.server.fabula.DAO.Request.SignUpRequest;
import com.server.fabula.DAO.Request.UpdateUserRequest;
import com.server.fabula.DAO.Response.JwtAuthenticationResponse;
import com.server.fabula.Entity.RoleEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.AuthenticationService;
import com.server.fabula.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        var user = UserEntity.builder().name(request.getName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .roleEntity(RoleEntity.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).id(user.getId()).build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).id(user.getId()).build();
    }

    @Override
    public UserEntity updateUser(UpdateUserRequest userRequest) {
        UserEntity user = userRepository.findById(userRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Check if the provided current password matches the stored password
        if (userRequest.getCurrentPassword() != null && !userRequest.getCurrentPassword().isEmpty()
                && !passwordEncoder.matches(userRequest.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid current password for security verification");
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

        return userRepository.save(user);
    }
}
