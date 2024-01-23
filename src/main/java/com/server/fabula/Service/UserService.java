package com.server.fabula.Service;

import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<UserEntity> findAll();

    UserEntity findUserById(Integer id);

    UserEntity saveUser(UserEntity user);

    UserEntity deleteUserById(Integer id);

    UserEntity updateUserById(UpdateUserRequest userRequest);

    boolean hasStoryForPrompt(int id, LocalDate date);
}
