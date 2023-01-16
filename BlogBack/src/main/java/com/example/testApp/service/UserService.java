package com.example.testApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testApp.models.User;


public interface UserService {
    public User getUser(Long idUser);
    public User createUser(User user); //this is not needed
    public User updateUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long idUser);
}
