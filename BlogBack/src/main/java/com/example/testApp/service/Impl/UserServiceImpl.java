package com.example.testApp.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testApp.models.User;
import com.example.testApp.repository.UserRepo;
import com.example.testApp.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
	public List<User> getAllUsers() {return userRepo.findAll();}

	UserRepo userRepo;
    @Override
    public User getUser(Long idUser) {
        return userRepo.findById(idUser).get();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {return userRepo.save(user);}

	@Override
	public void deleteUser(Long idUser) {
		
		userRepo.deleteById(idUser);}
}
