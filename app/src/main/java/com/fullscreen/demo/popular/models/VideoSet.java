package com.fullscreen.demo.popular.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by datct0407 on 10/6/15.
 */
public class VideoSet {
    @SerializedName(value="standard_resolution")
    private Video standardResolution;

    @SerializedName(value="low_bandwidth")
    private Video lowBandwidth;

    public Video getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Video standardResolution) {
        this.standardResolution = standardResolution;
    }

    public Video getLowBandwidth() {
        return lowBandwidth;
    }

    public void setLowBandwidth(Video lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }
}
