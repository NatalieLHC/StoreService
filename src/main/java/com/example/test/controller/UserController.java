package com.example.test.controller;


import com.example.test.dto.UserSearchParams;
import com.example.test.entity.User;
import com.example.test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@PreAuthorize("hasAuthority('MANAGER')")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }
    @GetMapping()
    public List<User> getAll(UserSearchParams userSearchParams) {
        return userService.getAll(userSearchParams);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws InterruptedException {
        var user = userService.getUserById(id);
        return user;
    }

    @PostMapping()
    public ResponseEntity<User> add(@RequestBody User user) {
        userService.add(user);
        var location = UriComponentsBuilder.fromPath("/users/" + user.getUserId()).build().toUri();
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable int id) {
        return userService.update(id, user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
