package com.rest.server.graphql.resolvers;

import com.rest.server.models.Comment;
import com.rest.server.graphql.inputss.CommentInput;
import com.rest.server.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class CommentMutationResolver {

    @Autowired
    private CommentService commentService;

    @MutationMapping
    public Comment createComment(@Argument CommentInput input) {
        Comment comment = new Comment();
        comment.setCommentMessage(input.getCommentMessage());
        comment.setCommentOwnerId(input.getCommentOwnerId());
        comment.setCommentPostId(input.getCommentPostId());
        comment.setCommentPublishDate(Instant.now().toString());

        return commentService.createComment(comment);
    }

    @MutationMapping
    public Comment updateComment(@Argument String id, @Argument CommentInput input) {
        Comment existing = commentService.singleComment(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment with id " + id + " not found"));

        Comment updated = new Comment();
        updated.setCommentMessage(input.getCommentMessage());
        updated.setCommentPostId(existing.getCommentPostId()); // preserve
        updated.setCommentOwnerId(existing.getCommentOwnerId()); // preserve
        updated.setCommentPublishDate(Instant.now().toString());

        return commentService.updateComment(id, updated);
    }

    @MutationMapping
    public String deleteComment(@Argument String id) {
        commentService.deleteComment(id);
        return id;
    }
}
