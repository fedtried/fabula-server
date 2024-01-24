package com.server.fabula.Service;

import com.server.fabula.Entity.StoryEntity;

import java.time.LocalDate;
import java.util.List;

public interface StoryService {

    List<StoryEntity> findAll();

    StoryEntity findStoryById(Integer id);

    StoryEntity saveStory(StoryEntity storyEntity, int userId, int promptId);

    StoryEntity updateStory(StoryEntity storyEntity);

    StoryEntity deleteStory(Integer id);

    List<StoryEntity> findStoryByDate(LocalDate date);
}
