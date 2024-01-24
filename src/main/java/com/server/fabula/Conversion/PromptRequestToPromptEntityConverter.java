package com.server.fabula.Conversion;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Model.Request.PromptRequest;
import com.server.fabula.Model.Story;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.parameters.P;

public class PromptRequestToPromptEntityConverter implements Converter<PromptRequest, PromptEntity> {

        @Override
        public PromptEntity convert(PromptRequest source) {
            PromptEntity promptEntity = new PromptEntity();
            promptEntity.setMode(source.getMode());
            promptEntity.setDate(source.getDate());
            promptEntity.setQuote(source.getQuote());
            return promptEntity;
        }
    }
