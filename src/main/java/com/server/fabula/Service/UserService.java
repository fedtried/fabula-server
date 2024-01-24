package com.server.fabula.Service;

import com.server.fabula.Model.User;
import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findAll();

    User findUserById(Integer id);

    User deleteUserById(Integer id);

    boolean hasStoryForPrompt(int id, LocalDate date);
}
