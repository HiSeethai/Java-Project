package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    public User findByUsername(String username) {
    	return userRepository.findByUsername(username);
    }
    public void saveUser(User user) {
    	userRepository.save(user);
    	System.out.println("User Saved Successfully!!!!"+user);
    }
}
