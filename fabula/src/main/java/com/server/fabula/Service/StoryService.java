package com.server.fabula.Service;

import com.server.fabula.Entity.Story;

import java.util.List;

public interface StoryService {

    List<Story> findAll();

    Story findStoryById(Integer id);

    Story saveStory(Story story, int userId, int promptId);

    Story updateStory(Story story);

    Story deleteStory(Integer id);
}
