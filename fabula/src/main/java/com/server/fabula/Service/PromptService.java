package com.server.fabula.Service;

import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;

public interface PromptService {

    Prompt findStoryById(Integer id);

    Prompt findStoryByDate(String date);

    Prompt savePrompt(Prompt prompt);
}
