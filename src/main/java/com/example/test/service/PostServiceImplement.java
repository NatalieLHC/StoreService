package com.example.test.service;

import com.example.test.entity.Post;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImplement implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostServiceImplement(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }
    public Post getPostById(int id){
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
    }
    public Post update(int id, Post post){
        var foundPost = getPostById(id);
        foundPost.setPostTitle(post.getPostTitle());
        foundPost.setPostContent(post.getPostContent());
        postRepository.save(foundPost);
        return foundPost;
    }
    public Post add(Post post) {
        post.setPostId(null);
        post.setDeleted(false);
        if (post.getUser().getUserId() == null) {
            userService.add(post.getUser());
        }
        return postRepository.save(post);
    }
    public void delete(int id){
        var foundUser = getPostById(id);
        foundUser.setDeleted(true);
        postRepository.save(foundUser);
    }
    public List<Post> getPostsByUserId(int userId){
        return postRepository.findByUserId(userId);
    }
}
