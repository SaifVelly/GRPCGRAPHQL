package com.rest.server.graphql.resolvers;

import com.rest.server.models.Comment;
import com.rest.server.graphql.inputs.CommentPage;
import com.rest.server.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CommentQueryResolver {

    @Autowired
    private CommentService commentService;

    @QueryMapping
    public CommentPage getAllComments(@Argument int page, @Argument int size) {
        Page<Comment> commentPage = commentService.allComments(PageRequest.of(page, size));
        return new CommentPage(commentPage.getContent(), commentPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public Comment getSingleComment(@Argument String id) {
        return commentService.singleComment(id).orElse(null);
    }

    @QueryMapping
    public CommentPage getCommentsByPost(@Argument String postId, @Argument int page, @Argument int size) {
        Page<Comment> commentPage = commentService.findCommentsByPostId(postId, page, size);
        return new CommentPage(commentPage.getContent(), commentPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public CommentPage getCommentsByUser(@Argument String userId, @Argument int page, @Argument int size) {
        Page<Comment> commentPage = commentService.findCommentsByUserId(userId, page, size);
        return new CommentPage(commentPage.getContent(), commentPage.getTotalElements(), page, size);
    }
}
