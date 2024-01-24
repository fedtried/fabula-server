package com.server.fabula.Conversion;

import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Model.Prompt;
import org.springframework.core.convert.converter.Converter;

public class PromptEntityToPromptConverter implements Converter<PromptEntity, Prompt> {

    @Override
    public Prompt convert(PromptEntity source) {
        return new Prompt(source.getId(), source.getDate(), source.getQuote());
    }
}
