package com.rest.server.graphql.inputs;

import com.rest.server.models.Tag;

import java.util.List;

public class TagPage {
    private List<Tag> data;
    private long total;
    private int page;
    private int size;

    public TagPage(List<Tag> data, long total, int page, int size) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<Tag> getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
