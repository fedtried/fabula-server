package com.server.fabula.User;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    @Bean
    public UserService userService(UserRepository userRepository){ return new UserServiceImpl(userRepository); }
}
