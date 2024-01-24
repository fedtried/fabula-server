package com.server.fabula.Service.Impl;

import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.User;
import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.UserService;

import java.time.LocalDate;
import java.util.List;

public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final UserService userService;
    private final PromptService promptService;


    public StoryServiceImpl(StoryRepository storyRepository, UserService userService, PromptService promptService) {
        this.storyRepository = storyRepository;
        this.userService = userService;
        this.promptService = promptService;
    }

    @Override
    public List<StoryEntity> findAll() {
        return storyRepository.findAll();
    }

    @Override
    public StoryEntity findStoryById(Integer id) {
        return storyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Couldn't find story."));
    }

    @Override
    public StoryEntity saveStory(StoryEntity storyEntity, int userId, int promptId) {
        UserEntity userEntity = userService.findUserById(userId);
        PromptEntity promptEntity  = promptService.findPromptById(promptId);
        storyEntity.setUser(userEntity);
        storyEntity.setPrompt(promptEntity);
        return storyRepository.save(storyEntity);
    }

    @Override
    public StoryEntity updateStory(StoryEntity storyEntity) {
        return storyRepository.save(storyEntity);
    }

    @Override
    public StoryEntity deleteStory(Integer id) {
        StoryEntity storyEntity = findStoryById(id);
        storyRepository.deleteById(id);
        return storyEntity;
    }

    @Override
    public List<Story> findStoryByDate(LocalDate date) {
        Prompt prompt = promptService.findStoryByDate(date);
        return storyRepository.findByPrompt(prompt);
    }

}
