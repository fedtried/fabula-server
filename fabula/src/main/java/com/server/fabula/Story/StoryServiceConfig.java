package com.server.fabula.Story;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StoryServiceConfig {

  public StoryService storiesService(StoryRepository storyRepository){
    return new StoryServiceImpl(storyRepository);
  }

}
