package com.fullscreen.demo.popular.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by datct0407 on 10/6/15.
 */
public class PhotoSet {
    @SerializedName(value="standard_resolution")
    private Photo standardResolution;

    @SerializedName(value="thumbnail")
    private Photo thumbnail;

    public Photo getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Photo standardResolution) {
        this.standardResolution = standardResolution;
    }

    public Photo getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Photo thumbnail) {
        this.thumbnail = thumbnail;
    }
}
