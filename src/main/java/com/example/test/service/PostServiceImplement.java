//package com.example.test.service;
//
//import com.example.test.dto.PostSearchParams;
//import com.example.test.entity.Post;
////import com.example.test.entity.Post_;
//import com.example.test.entity.User;
////import com.example.test.entity.User_;
//import com.example.test.exception.NotFoundException;
//import com.example.test.repository.PostRepository;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.JoinType;
//import javax.persistence.criteria.Predicate;
//import java.time.LocalDateTime;
//import java.util.List;
//@Service
//public class PostServiceImplement implements PostService {
//
//    private final PostRepository postRepository;
//    private final UserService userService;
//
//    public PostServiceImplement(PostRepository postRepository, UserService userService) {
//        this.postRepository = postRepository;
//        this.userService = userService;
//    }
////    @Transactional(readOnly = true)
////    public Page<Post> getAll(PostSearchParams postSearchParams, Pageable pageable) {
////        return postRepository.findAll((root, query, cb) -> {
////            Predicate predicate = cb.conjunction();
////            if (postSearchParams.getPostId() !=null){
////                predicate = cb.and(predicate, cb.equal(root.get(Post_.POST_ID), postSearchParams.getPostId()));
////            }
////            if (StringUtils.isNotEmpty(postSearchParams.getPostTitle())){
////                predicate = cb.and(predicate, cb.like(root.get(Post_.POST_TITLE), '%' + postSearchParams.getPostTitle() + '%'));
////            }
////            if (StringUtils.isNotEmpty(postSearchParams.getPostContent())){
////                predicate = cb.and(predicate, cb.like(root.get(Post_.POST_CONTENT), '%' + postSearchParams.getPostContent() + '%'));
////            }
////            if (postSearchParams.getPostDateFrom() !=null){
////                var createDateFrom = postSearchParams.getPostDateFrom().atStartOfDay();
////                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get(Post_.POST_DATE), createDateFrom));
////            }
////            if (postSearchParams.getPostDateTo() !=null){
////               var  createDateTo = postSearchParams.getPostDateTo().atTime(23, 59, 59);
////                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get(Post_.POST_DATE), createDateTo));
////            }
////            if (StringUtils.isNotEmpty(postSearchParams.getUsername())){
////                Join<Post, User> user = root.join(Post_.USER, JoinType.LEFT);
////                predicate = cb.and(predicate,cb.like(user.get(User_.USERNAME), postSearchParams.getUsername()+ '%'));
////            }
////            return predicate;
////        }, pageable);
////    }
//
//    public Post getPostById(int id){
//        return postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post not found"));
//    }
//    public Post update(int id, Post post){
//        var foundPost = getPostById(id);
//        foundPost.setPostTitle(post.getPostTitle());
//        foundPost.setPostContent(post.getPostContent());
//        postRepository.save(foundPost);
//        return foundPost;
//    }
//
//    @Transactional(rollbackFor = Throwable.class)
//    public Post add(Post post) {
//        post.setPostId(null);
//        post.setDeleted(false);
//        if (post.getUser().getUserId() == null) {
//            userService.add(post.getUser());
//        }
//        return postRepository.save(post);
//    }
//
//    public void delete(int id){
//        var foundUser = getPostById(id);
//        foundUser.setDeleted(true);
//        postRepository.save(foundUser);
//    }
//    public List<Post> getPostsByUserId(int userId){
//        return postRepository.findByUserId(userId);
//    }
//}
