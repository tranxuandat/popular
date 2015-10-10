package com.fullscreen.demo.popular.models;

import java.util.ArrayList;

/**
 * Created by datct0407 on 10/6/15.
 */
public class FetchData {
    Meta meta;
    ArrayList<Post> data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ArrayList<Post> getData() {
        return data;
    }

    public void setData(ArrayList<Post> data) {
        this.data = data;
    }
}
