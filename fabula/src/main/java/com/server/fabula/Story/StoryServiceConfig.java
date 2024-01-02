package com.server.fabula.Story;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoryServiceConfig {
  @Bean
  public StoryService storyService(StoryRepository storyRepository){
    return new StoryServiceImpl(storyRepository);
  }

}
