package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.Request.StoryRequest;
import com.server.fabula.Model.Story;
import com.server.fabula.Model.User;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.StoryService;
import com.server.fabula.Service.UserService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.core.convert.ConversionService;

public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final UserService userService;
    private final PromptService promptService;
    private final ConversionService conversionService;

    public StoryServiceImpl(
            StoryRepository storyRepository,
            UserService userService,
            PromptService promptService,
            ConversionService conversionService) {
        this.storyRepository = storyRepository;
        this.userService = userService;
        this.promptService = promptService;
        this.conversionService = conversionService;
    }

    @Override
    public List<Story> findAll() {
        return storyRepository.findAll().stream().map(x -> convertStoryEntityToStory(x)).toList();
    }

    @Override
    public Story findStoryById(Integer id) {
        return convertStoryEntityToStory(
                storyRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Couldn't find story.")));
    }

    @Override
    public Story createStory(StoryRequest storyRequest) {
        StoryEntity storyEntity = convertStoryRequestToEntity(storyRequest);
        storyRepository.save(storyEntity);

        return convertStoryEntityToStory(storyEntity);
    }

    @Override
    public Story updateStory(StoryEntity storyEntity) {
        return convertStoryEntityToStory(storyRepository.save(storyEntity));
    }

    @Override
    public Story deleteStory(Integer id) {
        Story story = findStoryById(id);
        storyRepository.deleteById(id);
        return story;
    }

    @Override
    public List<Story> findStoriesByDate(LocalDate date) {
        Prompt prompt = promptService.findStoryByDate(date);
        return storyRepository.findByPromptId(prompt.getId()).stream()
                .map(x -> convertStoryEntityToStory(x))
                .toList();
    }

    @Override
    public List<Story> findStoriesByUserId(int id) {
        User user = userService.findUserById(id);
        return storyRepository.findByUserName(user.getName()).stream()
                .map(x -> convertStoryEntityToStory(x))
                .toList();
    }

    private Story convertStoryEntityToStory(StoryEntity entity) {
        return conversionService.convert(entity, Story.class);
    }

    private StoryEntity convertStoryRequestToEntity(StoryRequest request) {
        return conversionService.convert(request, StoryEntity.class);
    }
}
