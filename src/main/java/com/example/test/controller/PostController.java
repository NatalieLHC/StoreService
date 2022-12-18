package com.example.test.controller;

import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    public List<Post> getAll(PostSearchParams postSearchParams){
        return postService.getAll();
    }
    @GetMapping("/{id}")
    public Post getPostsById(@PathVariable int id){
        return postService.getPostById(id);
    }
}
