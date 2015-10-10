package com.fullscreen.demo.popular.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by datct0407 on 10/6/15.
 */
public class Meta {
    private int code;

    @SerializedName(value="error_message")
    private String errorMessage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
