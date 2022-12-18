package com.example.test.controller;

import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
    @PostMapping()
    public ResponseEntity<Post> add(@RequestBody Post post){
        postService.add(post);
        var location = UriComponentsBuilder.fromPath("/posts/" + post.getPostId()).build().toUri();
        return ResponseEntity.created(location).body(post);
    }
}
