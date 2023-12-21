package com.example.nhom03_tuan07;

import java.io.Serializable;

public class Model_TinTuc implements Serializable {
    private int imageResourceId;
    private String title;
    private String description;
    private String imageUrl;

    public Model_TinTuc(int imageResourceId, String title, String description, String imageUrl) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

