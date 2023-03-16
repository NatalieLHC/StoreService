package com.example.test.service;

import com.example.test.dto.UserSearchParams;
import com.example.test.entity.User;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImplement(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;

        this.passwordEncoder = passwordEncoder;
    }
    public List<User> getAll(UserSearchParams userSearchParams){
        return userRepository.findAll();
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }
    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Username not found"));
    }

    public User update(int id, User user){
        var foundUser = getUserById(id);
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setEmail(user.getEmail());
        userRepository.save(foundUser);
        return foundUser;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public User add(User user){
        user.setUserId(null);
        user.setActive(true);
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
    public void delete(int id){
        var foundUser = getUserById(id);
        foundUser.setActive(false);
        userRepository.save(foundUser);
    }

}
