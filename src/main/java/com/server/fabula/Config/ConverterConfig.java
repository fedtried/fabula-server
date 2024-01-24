package com.server.fabula.Config;

import com.server.fabula.Conversion.*;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

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
    StoryRequestToStoryEntityConverter storyRequestToStoryEntityConverter(UserService userService, PromptService promptService){
        return new StoryRequestToStoryEntityConverter(userService,promptService);
    }

    @Bean
    UserEntityToUserConverter userEntityToUserConverter(){
        return new UserEntityToUserConverter();
    }
}
