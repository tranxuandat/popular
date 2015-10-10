package com.fullscreen.demo.popular.presenters;

import com.fullscreen.demo.popular.activities.MainActivity;
import com.fullscreen.demo.popular.api.PostApi;
import com.fullscreen.demo.popular.models.FetchData;
import com.fullscreen.demo.popular.components.DaggerPostApiComponent;
import com.fullscreen.demo.popular.components.PostApiComponent;
import com.fullscreen.demo.popular.modules.PostApiModule;
import com.fullscreen.demo.popular.utils.Constants;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by datct0407 on 10/6/15.
 */
public class PostPresenter {
    MainActivity mView;
    PostApi mApi;
    PostApiComponent mApiComponent;
    public PostPresenter(MainActivity view) {
        this.mView = view;
        mApiComponent = DaggerPostApiComponent.builder()
                .postApiModule(new PostApiModule())
                .build();
        mApi = mApiComponent.providePostApi();
    }
    public void loadPosts(final boolean isRefresh) {
        mApi.getPosts(Constants.INST_CLIENT_ID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FetchData>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.displayErrorSnackbar();
                    }

                    @Override
                    public void onNext(FetchData data) {
                        mView.hideProgress();
                        if (isRefresh) {
                            mView.refreshPosts(data.getData());
                        } else {
                            mView.addPosts(data.getData());
                        }
                    }
                });
    }
}
