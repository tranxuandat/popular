package com.fullscreen.demo.popular.components;

import com.fullscreen.demo.popular.activities.MainActivity;
import com.fullscreen.demo.popular.api.PostApi;
import com.fullscreen.demo.popular.modules.PostApiModule;

import dagger.Component;

/**
 * Created by datct0407 on 10/7/15.
 */
@Component(
        modules = {
                PostApiModule.class
        }
)
public interface PostApiComponent {
    PostApi providePostApi();
}
