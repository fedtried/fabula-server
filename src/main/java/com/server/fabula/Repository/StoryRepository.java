package com.server.fabula.Repository;

import java.util.List;
import java.util.Optional;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryEntity, Integer> {
  Optional<StoryEntity> findById(int id);
  List<StoryEntity> findByUserAndPrompt(UserEntity user, PromptEntity prompt);

  List<StoryEntity> findByPrompt(PromptEntity prompt);
}
