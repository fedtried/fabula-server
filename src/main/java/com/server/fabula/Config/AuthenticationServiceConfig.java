package com.server.fabula.Config;

import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.AuthenticationService;
import com.server.fabula.Service.Impl.AuthenticationServiceImpl;
import com.server.fabula.Service.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticationServiceConfig {

    @Bean
    public AuthenticationService authenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager ){
        return new AuthenticationServiceImpl(userRepository, passwordEncoder, jwtService, authenticationManager);
    }
}
