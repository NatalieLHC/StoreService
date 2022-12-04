package com.example.test.service;


import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.entity.User;
import com.example.test.entity.UserSearchParams;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAll(PostSearchParams postSearchParams);

    Post getPostById(int id);

    Post add(Post post);

    Post update(int id, Post post);

    void delete(int id);
}
