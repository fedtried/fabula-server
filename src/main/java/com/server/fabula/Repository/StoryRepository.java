package com.server.fabula.Repository;

import com.server.fabula.Entity.StoryEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
    Optional<StoryEntity> findById(int id);

    List<StoryEntity> findByUserIdAndPromptId(int userId, int promptId);

    List<StoryEntity> findByPromptId(int id);

    List<StoryEntity> findByUserName(String name);
}
