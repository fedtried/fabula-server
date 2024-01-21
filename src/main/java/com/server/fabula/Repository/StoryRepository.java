package com.server.fabula.Repository;

import java.util.List;
import java.util.Optional;

import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Integer> {
  Optional<Story> findById(int id);
  List<Story> findByUserAndPrompt(User user, Prompt prompt);
}
