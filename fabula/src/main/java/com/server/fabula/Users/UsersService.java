package com.server.fabula.Users;

import java.util.List;

public interface UsersService {

    List<Users> findAll();

    Users findUserById(Integer id);

    Users saveUser(Users user);

    void deleteUserById(Integer id);
}
