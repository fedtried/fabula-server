package com.server.fabula.Story;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
