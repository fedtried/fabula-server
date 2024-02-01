package com.server.fabula.Config;

import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.Impl.UserServiceImpl;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class UserServiceConfig {
    @Bean
    public UserService userService(
            UserRepository userRepository,
            StoryRepository storyRepository,
            PromptService promptService,
            ConversionService conversionService) {
        return new UserServiceImpl(
                userRepository, storyRepository, promptService, conversionService);
    }
}
