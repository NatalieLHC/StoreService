package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.entity.UserSearchParams;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> getAll(UserSearchParams userSearchParams);

    User getUserById(int id);

    User add(User user);

    User update(int id, User user);

    void delete(int id);
}
