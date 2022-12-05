package com.example.test.controller;

import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.entity.User;
import com.example.test.entity.UserSearchParams;
import com.example.test.service.PostService;
import com.example.test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

        private final PostService postService;

        public PostController(PostService postService) {

            this.postService = postService;
        }
        @GetMapping()
        public List<Post> getAll(PostSearchParams postSearchParams) {
            return postService.getAll(postSearchParams);
        }
        @GetMapping("/{id}")
        public Post getPostById(@PathVariable int id) {
            return postService.getPostById(id);
        }

        @PostMapping()
        public ResponseEntity<Post> add(@RequestBody Post post) {
            postService.add(post);
            var location = UriComponentsBuilder.fromPath("/posts/" + post.getPostId()).build().toUri();
            return ResponseEntity.created(location).body(post);
        }

        @PutMapping("/{id}")
        public Post update(@RequestBody Post post, @PathVariable int id) {
            return postService.update(id, post);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Post> delete(@PathVariable int id) {
            postService.delete(id);
            return ResponseEntity.noContent().build();
        }

}
