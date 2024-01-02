package com.server.fabula.Users;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostConstruct
    public void loadData(){

    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable int id){
        Users user = usersService.findUserById(id);
        if (user == null){
            throw new RuntimeException("User not found!");
        }
        return user;
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users user){
        user.setId(0);
        try {
            return usersService.saveUser(user);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/users")
    public Users updateUser(@RequestBody Users user){
        try {
            return usersService.saveUser(user);
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        Users user = usersService.findUserById(id);
        if (user == null){
            throw new RuntimeException("User not found!");
        }
        usersService.deleteUserById(id);
        return "Deleted user";
    }

}
