package com.javadev.validation.controller;

import com.javadev.validation.dto.UserRequest;
import com.javadev.validation.model.User;
import com.javadev.validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest userRequest) {
    return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

}
