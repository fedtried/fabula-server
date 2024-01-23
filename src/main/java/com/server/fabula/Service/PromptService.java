package com.server.fabula.Service;

import com.server.fabula.Model.Prompt;
import com.server.fabula.Entity.PromptEntity;

import java.time.LocalDate;

public interface PromptService {

    PromptEntity findPromptById(Integer id);

    PromptEntity findStoryByDate(LocalDate date);

    PromptEntity savePrompt(PromptEntity promptEntity);

}
