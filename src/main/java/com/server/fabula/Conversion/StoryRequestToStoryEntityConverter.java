package com.server.fabula.Conversion;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.Request.StoryRequest;
import com.server.fabula.Repository.PromptRepository;
import com.server.fabula.Repository.UserRepository;
import org.springframework.core.convert.converter.Converter;

public class StoryRequestToStoryEntityConverter implements Converter<StoryRequest, StoryEntity> {

    private final UserRepository userRepository;
    private final PromptRepository promptRepository;

    public StoryRequestToStoryEntityConverter(
            UserRepository userRepository, PromptRepository promptRepository) {
        this.userRepository = userRepository;
        this.promptRepository = promptRepository;
    }

    @Override
    public StoryEntity convert(StoryRequest source) {
        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setDate(source.getDate());
        storyEntity.setShare(source.getShare());
        storyEntity.setQuote(source.getQuote());

        UserEntity userEntity = userRepository.findById(source.getUserId()).orElseThrow();
        PromptEntity promptEntity = promptRepository.findById(source.getPromptId()).orElseThrow();
        storyEntity.setUser(userEntity);
        storyEntity.setPrompt(promptEntity);

        return storyEntity;
    }
}
