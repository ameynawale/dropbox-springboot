package com.service;

import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<User> login(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }

    public List<User> signup(String firstName,String lastName, String username, String password ){
        return userRepository.findByUsernameAndPassword(firstName,lastName);
    }

    public List<User> findsomething(String username){
        return userRepository.findByUsername(username);
    }
}