package com.server.fabula.Service;

import com.server.fabula.DTO.PromptDTO;
import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;

import java.time.LocalDate;

public interface PromptService {

    Prompt findPromptById(Integer id);

    Prompt findStoryByDate(LocalDate date);

    Prompt savePrompt(Prompt prompt);

    PromptDTO convertToDTO(Prompt prompt);
}
