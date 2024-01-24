package com.server.fabula.Controller;

import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Entity.UserEntity;
import com.server.fabula.Service.AuthenticationService;
import com.server.fabula.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authService;

    public UserController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/user")
    public List<UserEntity> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id){
        return ok(userService.findUserById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        user.setId(0);
        return ok(userService.saveUser(user));
    }

    @PutMapping("/user")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UpdateUserRequest userRequest){
        return ok(authService.updateUser(userRequest));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable int id) {
        return ok(userService.deleteUserById(id));
    }

    @GetMapping("/user/{id}/{date}")
    public ResponseEntity<Boolean> getIfStoryWrittenToday(@PathVariable int id, @PathVariable LocalDate date){
        return ok(userService.hasStoryForPrompt(id, date));
    }

}
