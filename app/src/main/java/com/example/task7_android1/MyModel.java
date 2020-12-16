package com.example.task7_android1;

import java.io.Serializable;

public class MyModel implements Serializable {

    private String title;
    private String subtitle;
    private int photo;

    public MyModel(String title, String subtitle, int photo) {
        this.title = title;
        this.subtitle = subtitle;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
