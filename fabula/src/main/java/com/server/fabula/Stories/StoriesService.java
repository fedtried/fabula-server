package com.server.fabula.Stories;

import java.util.List;

public interface StoriesService {

    List<Stories> findAll();

    Stories findStoryById(Integer id);

    Stories saveStory(Stories story);

    void deleteStoryById(Integer id);
}
