package com.server.fabula.Service;

import com.server.fabula.DTO.UserDTO;
import com.server.fabula.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findAll();

    User findUserById(Integer id);

    User saveUser(User user);

    User deleteUserById(Integer id);

    UserDTO convertToDTO(User user);

    boolean hasStoryForPrompt(int id, LocalDate date);
}
