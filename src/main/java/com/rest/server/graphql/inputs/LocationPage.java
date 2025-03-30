package com.rest.server.graphql.inputs;

import com.rest.server.models.Location;

import java.util.List;

public class LocationPage {
    private List<Location> data;
    private long total;
    private int page;
    private int size;

    public LocationPage(List<Location> data, long total, int page, int size) {
        this.data = data;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<Location> getData() {
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
