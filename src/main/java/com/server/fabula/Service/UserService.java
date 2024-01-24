package com.server.fabula.Service;

import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findAll();

    User findUserById(Integer id);

    User deleteUserById(Integer id);

    boolean hasStoryForPrompt(int id, LocalDate date);
}
