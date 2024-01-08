package com.server.fabula.Config;


import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.UserService;
import com.server.fabula.Service.Impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    @Bean
    public UserService userService(UserRepository userRepository, StoryRepository storyRepository){ return new UserServiceImpl(userRepository, storyRepository); }
}
