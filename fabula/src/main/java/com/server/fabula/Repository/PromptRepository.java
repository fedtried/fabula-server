package com.server.fabula.Repository;

import com.server.fabula.Entity.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromptRepository extends JpaRepository<Prompt, Integer> {

    Optional<Prompt> findByDate(String date);
}
