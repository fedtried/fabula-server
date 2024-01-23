package com.server.fabula.Service.Impl;

import com.server.fabula.DAO.Request.UpdateUserRequest;
import com.server.fabula.Model.User;
import com.server.fabula.Entity.PromptEntity;
import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StoryRepository storyRepository;
    private final PromptService promptService;

    public UserServiceImpl(UserRepository userRepository, StoryRepository storyRepository, PromptService promptService) {
        this.userRepository = userRepository;
        this.storyRepository = storyRepository;
        this.promptService = promptService;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity deleteUserById(Integer id) {
        UserEntity user = findUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public UserEntity updateUserById(UpdateUserRequest userRequest) {
        UserEntity user = findUserById(userRequest.getId());
        if(!Objects.equals(user.getName(), userRequest.getName())){
            user.setName(userRequest.getName());
        }
        if(!Objects.equals(user.getEmail(), userRequest.getEmail())){
            user.setEmail(userRequest.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public boolean hasStoryForPrompt(int id, LocalDate date) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
        PromptEntity promptEntity = promptService.findStoryByDate(date);
        List<StoryEntity> userStories = storyRepository.findByUserAndPrompt(user, promptEntity);
        return !userStories.isEmpty();
    }


}
