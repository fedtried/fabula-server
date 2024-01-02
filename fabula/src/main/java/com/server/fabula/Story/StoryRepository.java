package com.server.fabula.Story;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Integer> {
  Optional<Story> findById(int id);
}
