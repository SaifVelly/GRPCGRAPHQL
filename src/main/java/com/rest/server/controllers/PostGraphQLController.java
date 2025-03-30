//package com.rest.server.controllers;
//
//import com.rest.server.models.Post;
//import com.rest.server.services.PostService;
//import com.rest.server.graphql.inputss.PostPage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.graphql.data.method.annotation.*;
//import org.springframework.stereotype.Controller;
//import com.rest.server.graphql.inputss.PostInput;
//
//
//@Controller
//public class PostGraphQLController {
//
//    @Autowired
//    private PostService postService;
//
//    @QueryMapping
//    public Post getPost(@Argument String id) {
//        return postService.singlePost(id).orElse(null);
//    }
//
//    @QueryMapping
//    public PostPage allPosts(@Argument int page, @Argument int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Post> postsPage = postService.allPosts(pageable);
//        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
//    }
//
//    @QueryMapping
//    public PostPage searchPosts(@Argument String query, @Argument int page, @Argument int size){
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Post> postsPage = postService.searchPosts(query, pageable);
//        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
//    }
//
//    @QueryMapping
//    public PostPage postsByUser(@Argument String userId, @Argument int page, @Argument int size){
//        Page<Post> postsPage = postService.findPostsByUserId(userId, page, size);
//        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
//    }
//    @QueryMapping
//    public PostPage postsByTag(@Argument String tag, @Argument int page, @Argument int size) {
//        Page<Post> postsPage = postService.findPostsByTag(tag, page, size);
//        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
//    }
//
//    @MutationMapping
//    public Post createPost(@Argument PostInput input) {
//        Post post = new Post();
//        post.setPostText(input.getPostText());
//        post.setPostImage(input.getPostImage());
//        post.setPostLikes(input.getPostLikes());
//        post.setPostLink(input.getPostLink());
//        post.setPostTags(input.getPostTags());
//        post.setPostOwnerId(input.getPostOwnerId());
//        post.setPostPublishDate(java.time.Instant.now().toString());
//
//        return postService.createPost(post);
//    }
//
//    @MutationMapping

//    public Post updatePost(@Argument String id, @Argument PostInput input) {
//        Post post = new Post();
//        post.setPostText(input.getPostText());
//        post.setPostImage(input.getPostImage());
//        post.setPostLikes(input.getPostLikes());
//        post.setPostLink(input.getPostLink());
//        post.setPostTags(input.getPostTags());
//        post.setPostOwnerId(input.getPostOwnerId());
//        post.setPostPublishDate(java.time.Instant.now().toString());
//
//        return postService.updatePost(id, post);
//    }
//
//    @MutationMapping
//    public String deletePost(@Argument String id) {
//        postService.deletePost(id);
//        return id;
//    }
//
//
//
//}
