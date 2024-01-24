package com.server.fabula.Service.Impl;

import com.google.common.collect.Iterables;
import com.server.fabula.DTO.PromptDTO;
import com.server.fabula.DTO.UserDTO;
import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Entity.User;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PromptService promptService;

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
    public Story saveStory(Story story, int userId, int promptId) {
        User user = userService.findUserById(userId);
        UserDTO userDto = userService.convertToDTO(user);
        Prompt prompt = promptService.findPromptById(promptId);
        PromptDTO promptDto = promptService.convertToDTO(prompt);
        story.setUser(user);
        story.setPrompt(prompt);
        return storyRepository.save(story);
    }

    @Override
    public Story updateStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public Story deleteStory(Integer id) {
        Story story = findStoryById(id);
        storyRepository.deleteById(id);
        return story;
    }

    @Override
    public List<Story> findStoryByDate(LocalDate date) {
        Prompt prompt = promptService.findStoryByDate(date);
        return storyRepository.findByPrompt(prompt);
    }

}
