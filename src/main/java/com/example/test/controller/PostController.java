package com.example.test.controller;

import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Post> getAll(@RequestParam(required = false, defaultValue = "0") int page,
                             @RequestParam(required = false, defaultValue = "10") int size,
                             @RequestParam(required = false, defaultValue = "DESC") Sort.Direction direction,
                             @RequestParam(required = false, defaultValue = "postId") String field){
        Sort sorter = Sort.by(direction, field);
        return postService.getAll(PageRequest.of(page, size, sorter));
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
    //dfg
}
