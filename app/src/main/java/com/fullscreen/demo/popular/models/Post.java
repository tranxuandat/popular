package com.fullscreen.demo.popular.models;

/**
 * Created by datct0407 on 10/6/15.
 */
public class Post {

    private String type;
    private String id;
    private User user;
    private VideoSet videos;
    private PhotoSet images;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VideoSet getVideos() {
        return videos;
    }

    public void setVideos(VideoSet videos) {
        this.videos = videos;
    }

    public PhotoSet getImages() {
        return images;
    }

    public void setImages(PhotoSet images) {
        this.images = images;
    }
}
