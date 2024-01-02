package com.server.fabula.Stories;

import org.springframework.context.annotation.Configuration;

@Configuration
public class StoryServiceConfig {

  public StoriesService storiesService(StoriesRepository storiesRepository){
    return new StoriesServiceImpl(storiesRepository);
  }

}
