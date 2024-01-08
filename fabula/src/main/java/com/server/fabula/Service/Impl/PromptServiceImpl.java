package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Service.PromptService;

public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    public PromptServiceImpl(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @Override
    public Prompt findStoryById(Integer id) {
        return promptRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public Prompt findStoryByDate(String date) {
        return promptRepository.findByDate(date).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public Prompt savePrompt(Prompt prompt) {
        return promptRepository.save(prompt);
    }
}
