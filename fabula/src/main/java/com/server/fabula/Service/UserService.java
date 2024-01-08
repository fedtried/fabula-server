package com.server.fabula.Service;

import com.server.fabula.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<User> findAll();

    User findUserById(Integer id);

    User saveUser(User user);

    User deleteUserById(Integer id);
}
