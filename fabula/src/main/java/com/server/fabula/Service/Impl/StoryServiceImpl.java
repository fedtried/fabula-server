package com.server.fabula.Service.Impl;

import com.google.common.collect.Iterables;
import com.server.fabula.Entity.Story;
import com.server.fabula.Entity.User;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    @Autowired
    private UserService userService;

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
    public Story saveStory(Story story, int id) {
        User user = userService.findUserById(id);
        story.setUser(user);
        List<Story> stories = user.getStories();
        String storyId = Integer.toString(story.getId());
        if(storyId.equals("0")){
            stories.add(story);
        } else {
            int index = Iterables.indexOf(stories, s -> storyId.equals(Integer.toString(s.getId())));
            System.out.println(index);
            stories.set(index, story);
        }
        user.setStories(stories);
        userService.saveUser(user);
        return storyRepository.save(story);
    }

    @Override
    public Story deleteStory(Integer id) {
        Story story = findStoryById(id);
        storyRepository.deleteById(id);
        return story;
    }

}
