package com.rest.server.graphql.inputs;

import java.util.List;

public class PostInput {
    private String postText;
    private String postImage;
    private Integer postLikes;
    private String postLink;
    private List<String> postTags;
    private String postOwnerId;

    public PostInput() {}

    public PostInput(String postText, String postImage, Integer postLikes, String postLink, List<String> postTags, String postOwnerId) {
        this.postText = postText;
        this.postImage = postImage;
        this.postLikes = postLikes;
        this.postLink = postLink;
        this.postTags = postTags;
        this.postOwnerId = postOwnerId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Integer getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public List<String> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<String> postTags) {
        this.postTags = postTags;
    }

    public String getPostOwnerId() {
        return postOwnerId;
    }

    public void setPostOwnerId(String postOwnerId) {
        this.postOwnerId = postOwnerId;
    }
}
