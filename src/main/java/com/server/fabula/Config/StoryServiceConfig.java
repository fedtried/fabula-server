package com.server.fabula.Config;

import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.Impl.StoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoryServiceConfig {
  @Bean
  public StoryService storyService(StoryRepository storyRepository){
    return new StoryServiceImpl(storyRepository);
  }

}
