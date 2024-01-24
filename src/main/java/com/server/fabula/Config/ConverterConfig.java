package com.server.fabula.Config;

import com.server.fabula.Conversion.*;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    @Bean
    PromptEntityToPromptConverter promptEntityToPromptConverter(){
        return new PromptEntityToPromptConverter();
    }

    @Bean
    PromptRequestToPromptEntityConverter promptRequestToPromptEntityConverter(){
        return new PromptRequestToPromptEntityConverter();
    }

    @Bean
    StoryEntityToStoryConverter storyEntityToStoryConverter(){
        return new StoryEntityToStoryConverter();
    }

    @Bean
    StoryRequestToStoryEntityConverter storyRequestToStoryEntityConverter(UserRepository userRepository, PromptRepository promptRepository){
        return new StoryRequestToStoryEntityConverter(userRepository, promptRepository);
    }

    @Bean
    UserEntityToUserConverter userEntityToUserConverter(){
        return new UserEntityToUserConverter();
    }
}
