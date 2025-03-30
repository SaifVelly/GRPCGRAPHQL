package com.rest.server.graphql.resolvers;

import com.rest.server.models.Post;
import com.rest.server.graphql.inputs.PostPage;
import com.rest.server.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostQueryResolver {

    @Autowired
    private PostService postService;

    @QueryMapping
    public Post getPost(@Argument String id) {
        return postService.singlePost(id).orElse(null);
    }

    @QueryMapping
    public PostPage allPosts(@Argument int page, @Argument int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postsPage = postService.allPosts(pageable);
        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public PostPage searchPosts(@Argument String query, @Argument int page, @Argument int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> postsPage = postService.searchPosts(query, pageable);
        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public PostPage postsByUser(@Argument String userId, @Argument int page, @Argument int size) {
        Page<Post> postsPage = postService.findPostsByUserId(userId, page, size);
        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public PostPage postsByTag(@Argument String tag, @Argument int page, @Argument int size) {
        Page<Post> postsPage = postService.findPostsByTag(tag, page, size);
        return new PostPage(postsPage.getContent(), postsPage.getTotalElements(), page, size);
    }
}
