package com.server.fabula.Config;

import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Service.Impl.PromptServiceImpl;
import com.server.fabula.Service.PromptService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class PromptServiceConfig {
    @Bean
    public PromptService promptService(
            PromptRepository promptRepository, ConversionService conversionService) {
        return new PromptServiceImpl(promptRepository, conversionService);
    }
}
