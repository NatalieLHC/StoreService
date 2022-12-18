package com.example.test.service;


import com.example.test.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> getAll();

    Post getPostById(int id);

    Post add(Post post);

    Post update(int id, Post post);

    List<Post> getPostsByUserId(int Userid);

    void delete(int id);
}
