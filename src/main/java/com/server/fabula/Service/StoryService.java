package com.server.fabula.Service;

import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Model.Request.StoryRequest;
import com.server.fabula.Model.Story;
import java.time.LocalDate;
import java.util.List;

public interface StoryService {

    List<Story> findAll();

    Story findStoryById(Integer id);

    Story createStory(StoryRequest storyRequest);

    Story updateStory(StoryEntity storyEntity);

    Story deleteStory(Integer id);

    List<Story> findStoriesByDate(LocalDate date);

    List<Story> findStoriesByUserId(int id);

}
