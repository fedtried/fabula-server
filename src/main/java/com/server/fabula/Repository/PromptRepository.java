package com.server.fabula.Repository;

import com.server.fabula.Entity.PromptEntity;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<PromptEntity, Integer> {

    Optional<PromptEntity> findByDate(LocalDate date);
}
