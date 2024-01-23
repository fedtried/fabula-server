package com.server.fabula.Service.Impl;

import com.server.fabula.Model.Prompt;
import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Service.PromptService;

import java.time.LocalDate;

public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    public PromptServiceImpl(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @Override
    public PromptEntity findPromptById(Integer id) {
        return promptRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public PromptEntity findStoryByDate(LocalDate date) {
        return promptRepository.findByDate(date).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public PromptEntity savePrompt(PromptEntity promptEntity) {
        return promptRepository.save(promptEntity);
    }

}
