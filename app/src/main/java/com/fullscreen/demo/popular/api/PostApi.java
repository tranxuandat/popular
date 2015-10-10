package com.fullscreen.demo.popular.api;

import com.fullscreen.demo.popular.models.FetchData;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by datct0407 on 10/6/15.
 */
public interface PostApi {
    @GET("/v1/media/popular")
    public Observable<FetchData>
    getPosts(@Query("client_id") String clientId);
}
