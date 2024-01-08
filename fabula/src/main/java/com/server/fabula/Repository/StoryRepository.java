package com.server.fabula.Repository;

import java.util.Optional;

import com.server.fabula.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Integer> {
  Optional<Story> findById(int id);
}
