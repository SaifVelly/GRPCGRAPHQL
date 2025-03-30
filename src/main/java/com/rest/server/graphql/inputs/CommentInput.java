package com.rest.server.graphql.inputs;

public class CommentInput {
    private String commentMessage;
    private String commentOwnerId;
    private String commentPostId;

    public CommentInput() {}

    public CommentInput(String commentMessage, String commentOwnerId, String commentPostId) {
        this.commentMessage = commentMessage;
        this.commentOwnerId = commentOwnerId;
        this.commentPostId = commentPostId;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public String getCommentOwnerId() {
        return commentOwnerId;
    }

    public void setCommentOwnerId(String commentOwnerId) {
        this.commentOwnerId = commentOwnerId;
    }

    public String getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(String commentPostId) {
        this.commentPostId = commentPostId;
    }
}
