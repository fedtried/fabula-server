package com.server.fabula.Conversion;

import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.User;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserConverter implements Converter<UserEntity, User> {

    @Override
    public User convert(UserEntity source) {
        return new User(source.getId(), source.getName(), source.getEmail(), source.getPassword());
    }
}
