package com.server.fabula.Config;

import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.Impl.StoryServiceImpl;
import com.server.fabula.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class StoryServiceConfig {
  @Bean
  public StoryService storyService(StoryRepository storyRepository, UserService userService, PromptService promptService, ConversionService conversionService){
    return new StoryServiceImpl(storyRepository, userService,promptService, conversionService);
  }

}
