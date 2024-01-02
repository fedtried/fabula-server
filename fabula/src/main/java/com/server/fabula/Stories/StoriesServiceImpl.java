package com.server.fabula.Stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StoriesServiceImpl implements StoriesService{

    private StoriesRepository storiesRepository;

    @Autowired
    public StoriesServiceImpl(StoriesRepository storiesRepository) {
        this.storiesRepository = storiesRepository;
    }

    @Override
    public List<Stories> findAll() {
        return storiesRepository.findAll();
    }

    @Override
    public Stories findStoryById(Integer id) {
        Optional<Stories> result = storiesRepository.findById(id);
        Stories story = null;
        if(result.isPresent()){
            story = result.get();
        } else {
            throw new RuntimeException("Couldn't find story.");
        }
        return story;
    }

    @Override
    public Stories saveStory(Stories story) {
        return storiesRepository.save(story);
    }

    @Override
    public void deleteStoryById(Integer id) {
        storiesRepository.deleteById(id);
    }
}
