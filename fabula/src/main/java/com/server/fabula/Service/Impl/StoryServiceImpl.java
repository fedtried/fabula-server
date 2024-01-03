package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.Story;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.StoryService;

import java.util.List;

public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    @Override
    public Story findStoryById(Integer id) {
        return storyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Couldn't find story."));
    }

    @Override
    public Story saveStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public Story deleteStory(Integer id) {
        Story story = findStoryById(id);
        storyRepository.deleteById(id);
        return story;
    }

}
