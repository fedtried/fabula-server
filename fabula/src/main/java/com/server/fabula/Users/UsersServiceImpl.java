package com.server.fabula.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(Integer id) {
        Optional<Users> result = usersRepository.findById(id);
        Users user = null;
        if(result.isPresent()){
            user = result.get();
        } else {
            throw new RuntimeException("Couldn't find user.");
        }
        return user;
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        usersRepository.deleteById(id);
    }
}
