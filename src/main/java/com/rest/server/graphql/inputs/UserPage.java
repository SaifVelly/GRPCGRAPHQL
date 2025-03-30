package com.rest.server.graphql.inputs;

import com.rest.server.models.User;
import java.util.List;

public class UserPage {

    private List<User> data;
    private int total;
    private int page;
    private int size;

    public UserPage(List<User> data, long total, int page, int size) {
        this.data = data;
        this.total = (int) total;
        this.page = page;
        this.size = size;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
