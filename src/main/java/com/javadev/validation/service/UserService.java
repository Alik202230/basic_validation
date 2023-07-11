package com.javadev.validation.service;

import com.javadev.validation.dto.UserRequest;
import com.javadev.validation.exception.UserNotFoundException;
import com.javadev.validation.model.User;
import com.javadev.validation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(UserRequest userRequest) {
    final String name = userRequest.getName();
    final String email = userRequest.getEmail();
    final String mobile = userRequest.getMobile();
    final String gender = userRequest.getGender();
    final int age = userRequest.getAge();
    final String nationality = userRequest.getNationality();

    User user = new User(name, email, mobile, gender, age, nationality);

    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Integer id) {
    return userRepository.findAll()
        .stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new UserNotFoundException("User with the ID: " + id + " is not found"));
  }

}
