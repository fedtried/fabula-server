package com.server.fabula.Controller;

import com.server.fabula.Entity.User;
import com.server.fabula.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return ok(userService.findUserById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        user.setId(0);
        return ok(userService.saveUser(user));
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ok(userService.saveUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        return ok(userService.deleteUserById(id));
    }

}
