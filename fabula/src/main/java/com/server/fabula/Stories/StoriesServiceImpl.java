package com.server.fabula.Stories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoriesServiceImpl implements StoriesService{

    private StoriesDAO storiesDAO;

    @Autowired
    public StoriesServiceImpl(StoriesDAO storiesDAO) {
        this.storiesDAO = storiesDAO;
    }

    @Override
    public List<Stories> findAll() {
        return storiesDAO.findAll();
    }

    @Override
    public Stories findStoryById(Integer id) {
        return storiesDAO.findStoryById(id);
    }

    @Transactional
    @Override
    public Stories saveStory(Stories story) {
        return storiesDAO.saveStory(story);
    }

    @Transactional
    @Override
    public void deleteStoryById(Integer id) {
        storiesDAO.deleteStoryById(id);
    }
}
