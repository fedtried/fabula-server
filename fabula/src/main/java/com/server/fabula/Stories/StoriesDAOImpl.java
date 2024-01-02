package com.server.fabula.Stories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StoriesDAOImpl implements StoriesDAO{

    private EntityManager entityManager;

    @Autowired
    public StoriesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Stories story) {
        entityManager.persist(story );
    }

    @Override
    public List<Stories> findAll() {
        TypedQuery<Stories> query = entityManager.createQuery("from Stories", Stories.class);

        return query.getResultList();
    }

    @Override
    public Stories findStoryById(Integer id) {
        return entityManager.find(Stories.class, id);
    }

    @Override
    public Stories saveStory(Stories story) {
        return entityManager.merge(story);
    }

    @Override
    public void deleteStoryById(Integer id) {
        Stories story = entityManager.find(Stories.class, id);
        entityManager.remove(story);

    }
}
