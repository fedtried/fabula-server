package com.server.fabula.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(Integer id);

    User saveUser(User user);

    User deleteUserById(Integer id);
}
