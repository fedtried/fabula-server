package com.server.fabula.Service.Impl;

import com.server.fabula.DAO.Request.UpdateUserRequest;
import com.server.fabula.DTO.UserDTO;
import com.server.fabula.Entity.Prompt;
import com.server.fabula.Entity.Story;
import com.server.fabula.Entity.User;
import com.server.fabula.Repository.StoryRepository;
import com.server.fabula.Repository.UserRepository;
import com.server.fabula.Service.PromptService;
import com.server.fabula.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StoryRepository storyRepository;
    @Autowired
    private PromptService promptService;

    public UserServiceImpl(UserRepository userRepository, StoryRepository storyRepository) {
        this.userRepository = userRepository;
        this.storyRepository = storyRepository;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUserById(Integer id) {
        User user = findUserById(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User updateUserById(UpdateUserRequest userRequest) {
        User user = findUserById(userRequest.getId());
        if(!Objects.equals(user.getName(), userRequest.getName())){
            user.setName(userRequest.getName());
        }
        if(!Objects.equals(user.getEmail(), userRequest.getEmail())){
            user.setEmail(userRequest.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public boolean hasStoryForPrompt(int id, LocalDate date) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Couldn't find user."));
        Prompt prompt = promptService.findStoryByDate(date);
        List<Story> userStories = storyRepository.findByUserAndPrompt(user, prompt);
        return !userStories.isEmpty();
    }


}
