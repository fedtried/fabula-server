package com.server.fabula.Conversion;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.Request.PromptRequest;
import com.server.fabula.Model.Request.StoryRequest;
import com.server.fabula.Model.User;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class StoryRequestToStoryEntityConverter implements Converter<StoryRequest, StoryEntity> {

    private final UserService userService;
    private final PromptService promptService;

    public StoryRequestToStoryEntityConverter(UserService userService, PromptService promptService){
        this.userService = userService;
        this.promptService = promptService;
    }

    @Override
    public StoryEntity convert(StoryRequest source) {
        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setDate(source.getDate());
        storyEntity.setShare(source.getShare());
        storyEntity.setQuote(source.getQuote());
//
//        User user = userService.findUserById(source.getUserId());
//        Prompt prompt  = promptService.findPromptById(source.getPromptId());
//
//        UserEntity userEntity = conversionService.convert(user, UserEntity.class);
//        PromptEntity promptEntity = conversionService.convert(prompt, PromptEntity.class);

//        storyEntity.setUser(userEntity);
//        storyEntity.setPrompt(promptEntity);
        //TODO need to add user and many to many shit here;
        return storyEntity;
    }
}
