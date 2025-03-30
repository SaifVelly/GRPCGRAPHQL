package com.rest.server.graphql.inputs;

import com.rest.server.models.User;

import java.util.List;

public class UserPage {

    private List<User> users;
    private long totalElements;
    private int currentPage;
    private int pageSize;

    public UserPage(List<User> users, long totalElements, int currentPage, int pageSize) {
        this.users = users;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
