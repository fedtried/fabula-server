package com.server.fabula.Conversion;

import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Model.Story;
import org.springframework.core.convert.converter.Converter;

public class StoryEntityToStoryConverter implements Converter<StoryEntity, Story> {

    @Override
    public Story convert(StoryEntity source) {
        return new Story(
                source.getId(),
                source.getDate(),
                source.getQuote(),
                source.getWriting(),
                source.getShare());
    }
}
