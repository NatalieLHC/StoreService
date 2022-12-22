package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.dto.UserSearchParams;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.PostRepository;
import com.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Username not found"));
    }
//    public List<User> getUserPosts(int id) {
//        if(postRepository.findByUserId(id).isEmpty()){
//            throw new NotFoundException("This user has no posts!");
//        }
////        return postRepository.findAllByPostId(id);
//    }
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
        return userRepository.save(user);
    }
    public void delete(int id){
        var foundUser = getUserById(id);
        foundUser.setActive(false);
        userRepository.save(foundUser);
    }

}
