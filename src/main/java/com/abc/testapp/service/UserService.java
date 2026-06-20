package com.abc.testapp.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.abc.testapp.entity.User;
import com.abc.testapp.repo.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo,
                       PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void register(User user) {

        user.setPassword(
                encoder.encode(user.getPassword()));

        user.setRole("USER");

        repo.save(user);
    }
}