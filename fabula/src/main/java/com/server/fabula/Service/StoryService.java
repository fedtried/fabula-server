package com.server.fabula.Service;

import com.server.fabula.Entity.Story;

import java.util.List;

public interface StoryService {

    List<Story> findAll();

    Story findStoryById(Integer id);

    Story saveStory(Story story, int id);

    Story deleteStory(Integer id);
}
