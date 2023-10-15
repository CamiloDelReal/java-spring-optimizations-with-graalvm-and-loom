package com.example.testservicejava.v1.services;

import com.example.testservicejava.v1.entities.User;
import com.example.testservicejava.v1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }
}
