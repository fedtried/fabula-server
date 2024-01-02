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
        Optional<Story> result = storyRepository.findById(id);
        Story story = null;
        if(result.isPresent()){
            story = result.get();
        } else {
            throw new RuntimeException("Couldn't find story.");
        }
        return story;
    }

    @Override
    public Story saveStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public void deleteStoryById(Integer id) {
        storyRepository.deleteById(id);
    }

}
