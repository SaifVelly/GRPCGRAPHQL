package com.rest.server.graphql.resolvers;

import com.rest.server.models.Post;
import com.rest.server.graphql.inputss.PostInput;
import com.rest.server.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class PostMutationResolver {

    @Autowired
    private PostService postService;

    @MutationMapping
    public Post createPost(@Argument PostInput input) {
        Post post = new Post();
        post.setPostText(input.getPostText());
        post.setPostImage(input.getPostImage());
        post.setPostLikes(input.getPostLikes());
        post.setPostLink(input.getPostLink());
        post.setPostTags(input.getPostTags());
        post.setPostOwnerId(input.getPostOwnerId());
        post.setPostPublishDate(Instant.now().toString());

        return postService.createPost(post);
    }

    @MutationMapping
    public Post updatePost(@Argument String id, @Argument PostInput input) {
        Post existing = postService.singlePost(id)
                .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " not found"));

        if (input.getPostOwnerId() != null && !input.getPostOwnerId().equals(existing.getPostOwnerId())) {
            throw new IllegalArgumentException("You cannot modify the owner of the post.");
        }

        Post updatedPost = new Post();
        updatedPost.setPostText(input.getPostText());
        updatedPost.setPostImage(input.getPostImage());
        updatedPost.setPostLikes(input.getPostLikes());
        updatedPost.setPostLink(input.getPostLink());
        updatedPost.setPostTags(input.getPostTags());
        updatedPost.setPostOwnerId(existing.getPostOwnerId()); // force to keep original owner
        updatedPost.setPostPublishDate(Instant.now().toString());

        return postService.updatePost(id, updatedPost);
    }

    @MutationMapping
    public String deletePost(@Argument String id) {
        postService.deletePost(id);
        return id;
    }
}
