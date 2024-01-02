package com.server.fabula.Story;

import java.util.List;

public interface StoryService {

    List<Story> findAll();

    Story findStoryById(Integer id);

    Story saveStory(Story story);

    Story deleteStory(Integer id);
}
