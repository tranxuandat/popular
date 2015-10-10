package com.fullscreen.demo.popular.modules;

import com.fullscreen.demo.popular.api.PostApi;
import com.fullscreen.demo.popular.utils.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;

/**
 * Created by datct0407 on 10/7/15.
 */
@Module
public class PostApiModule {
    @Provides RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };
    }
    @Provides
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(Constants.INST_POPULAR_POST_URL);
    }
    @Provides
    RestAdapter provideRestAdapter(Endpoint endpoint, RequestInterceptor requestInterceptor) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.NONE)
                .build();
        return restAdapter;
    }

    @Provides
    PostApi providePostApi(RestAdapter restAdapter) {
        return restAdapter.create(PostApi.class);
    }
}
