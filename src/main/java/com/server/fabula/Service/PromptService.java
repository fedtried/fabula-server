package com.server.fabula.Service;

import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.Request.PromptRequest;
import java.time.LocalDate;

public interface PromptService {

    Prompt findPromptById(Integer id);

    Prompt findStoryByDate(LocalDate date);

    Prompt savePrompt(PromptRequest promptRequest);
}
