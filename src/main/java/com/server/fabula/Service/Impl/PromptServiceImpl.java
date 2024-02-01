package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.Request.PromptRequest;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Service.PromptService;
import java.time.LocalDate;
import org.springframework.core.convert.ConversionService;

public class PromptServiceImpl implements PromptService {

    private final PromptRepository promptRepository;
    private final ConversionService conversionService;

    public PromptServiceImpl(
            PromptRepository promptRepository, ConversionService conversionService) {
        this.promptRepository = promptRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Prompt findPromptById(Integer id) {
        return convertPromptEntityToPrompt(
                promptRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Couldn't find user.")));
    }

    @Override
    public Prompt findStoryByDate(LocalDate date) {
        return convertPromptEntityToPrompt(
                promptRepository
                        .findByDate(date)
                        .orElseThrow(() -> new RuntimeException("Couldn't find user.")));
    }

    @Override
    public Prompt savePrompt(PromptRequest promptRequest) {
        PromptEntity promptEntity = convertPromptRequestToEntity(promptRequest);
        promptRepository.save(promptEntity);
        return convertPromptEntityToPrompt(promptEntity);
    }

    private Prompt convertPromptEntityToPrompt(PromptEntity entity) {
        return conversionService.convert(entity, Prompt.class);
    }

    private PromptEntity convertPromptRequestToEntity(PromptRequest request) {
        return conversionService.convert(request, PromptEntity.class);
    }
}
