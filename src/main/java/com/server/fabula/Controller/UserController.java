package com.server.fabula.Controller;

import static org.springframework.http.ResponseEntity.ok;

import com.server.fabula.Model.Request.UpdateUserRequest;
import com.server.fabula.Model.User;
import com.server.fabula.Service.AuthenticationService;
import com.server.fabula.Service.UserService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ok(userService.findUserById(id));
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest userRequest) {
        return ok(authService.updateUser(userRequest));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        return ok(userService.deleteUserById(id));
    }

    @GetMapping("/user/{id}/{date}")
    public ResponseEntity<Boolean> getIfStoryWrittenToday(
            @PathVariable int id, @PathVariable LocalDate date) {
        return ok(userService.hasStoryForPrompt(id, date));
    }
}
