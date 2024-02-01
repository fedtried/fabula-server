package com.server.fabula.Service.Impl;

import com.server.fabula.Entity.StoryEntity;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Model.Prompt;
import com.server.fabula.Model.User;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StoryRepository storyRepository;
    private final PromptService promptService;
    private final ConversionService conversionService;

    public UserServiceImpl(
            UserRepository userRepository,
            StoryRepository storyRepository,
            PromptService promptService,
            ConversionService conversionService) {
        this.userRepository = userRepository;
        this.storyRepository = storyRepository;
        this.promptService = promptService;
        this.conversionService = conversionService;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository
                        .findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(x -> conversionService.convert(x, User.class))
                .toList();
    }

    @Override
    public User findUserById(Integer id) {
        UserEntity userEntity =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Couldn't find user."));
        return convertUserEntityToUser(userEntity);
    }

    @Override
    public User deleteUserById(Integer id) {
        User user = findUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public boolean hasStoryForPrompt(int id, LocalDate date) {
        UserEntity user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Couldn't find user."));
        Prompt prompt = promptService.findStoryByDate(date);
        List<StoryEntity> userStories =
                storyRepository.findByUserIdAndPromptId(user.getId(), prompt.getId());
        return !userStories.isEmpty();
    }

    private User convertUserEntityToUser(UserEntity entity) {
        return conversionService.convert(entity, User.class);
    }
}
