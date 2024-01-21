package com.server.fabula.Service.Impl;

import com.server.fabula.DTO.PromptDTO;
import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Service.PromptService;

import java.time.LocalDate;

public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;

    public PromptServiceImpl(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    @Override
    public Prompt findPromptById(Integer id) {
        return promptRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public Prompt findStoryByDate(LocalDate date) {
        return promptRepository.findByDate(date).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public Prompt savePrompt(Prompt prompt) {
        return promptRepository.save(prompt);
    }

    @Override
    public PromptDTO convertToDTO(Prompt prompt) {
        return new PromptDTO(prompt.getId(), prompt.getDate(), prompt.getQuote());
    }
}
