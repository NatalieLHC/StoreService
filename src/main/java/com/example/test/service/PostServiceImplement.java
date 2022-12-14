package com.example.test.service;

import com.example.test.entity.Post;
import com.example.test.entity.PostSearchParams;
import com.example.test.entity.User;
import com.example.test.entity.UserSearchParams;
import com.example.test.exception.NotFoundException;
import com.example.test.repository.PostRepository;
import com.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImplement implements PostService {

    private final PostRepository postRepository;

    public PostServiceImplement(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll(PostSearchParams postSearchParams) {
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
    public Post add(Post post){
        post.setPostId(null);
        post.setDeleted(false);
        return postRepository.save(post);
    }
    public void delete(int id){
        var foundUser = getPostById(id);
        foundUser.setDeleted(true);
        postRepository.save(foundUser);
    }
    public List<Post>getByUserId(int userId){
        return postRepository.findByUserId(userId);
    }
}
