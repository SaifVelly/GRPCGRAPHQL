package com.rest.server.graphql.inputs;

import com.rest.server.models.Comment;

import java.util.List;

public class CommentPage {
    private List<Comment> data;
    private long total;
    private int page;
    private int size;

    public CommentPage() {}

    public CommentPage(List<Comment> data, long total, int page, int size) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<Comment> getData() {
        return data;
    }

    public void setData(List<Comment> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
