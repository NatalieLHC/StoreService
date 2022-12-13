package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.entity.UserSearchParams;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.PostRepository;
import com.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserServiceImplement(UserRepository userRepository, PostRepository postRepository){
        this.userRepository=userRepository;
        this.postRepository=postRepository;
    }
    public List<User> getAll(UserSearchParams userSearchParams){
        return userRepository.findAll();
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User update(int id, User user){
        var foundUser = getUserById(id);
        foundUser.setUsername(user.getUsername());
        foundUser.setPassword(user.getPassword());
        foundUser.setEmail(user.getEmail());
        userRepository.save(foundUser);
        return foundUser;
    }
    public User add(User user){
        user.setUserId(null);
        user.setActive(true);
        return userRepository.save(user);
    }
    public void delete(int id){
        var foundUser = getUserById(id);
        foundUser.setActive(false);
        userRepository.save(foundUser);
    }

}
