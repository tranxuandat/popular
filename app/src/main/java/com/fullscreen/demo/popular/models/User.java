package com.fullscreen.demo.popular.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by datct0407 on 10/6/15.
 */
public class User {

    private String username;

    @SerializedName(value="profile_picture")
    private String profilePicture;

    private String id;

    @SerializedName(value="full_name")
    private String fullName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
