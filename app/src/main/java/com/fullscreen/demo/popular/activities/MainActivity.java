package com.fullscreen.demo.popular.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.fullscreen.demo.popular.R;
import com.fullscreen.demo.popular.adapters.PostAdapter;
import com.fullscreen.demo.popular.models.Post;
import com.fullscreen.demo.popular.presenters.PostPresenter;
import com.fullscreen.demo.popular.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.content_swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @InjectView(R.id.content_recycler)
    RecyclerView mRecyclerView;

    @InjectView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    PostAdapter mPostAdapter;
    PostPresenter mPostPresenter;
    boolean isLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        initializeAdapter();

        mPostPresenter = new PostPresenter(this);
        mPostPresenter.loadPosts(false);
        initializeRefreshLayout();
        initializeOnScrollForRecyclerView();
    }

    public void initializeAdapter() {
        mPostAdapter = new PostAdapter(this, new ArrayList<Post>());
        mRecyclerView.setAdapter(mPostAdapter);
    }

    public void initializeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPostPresenter.loadPosts(true);
            }
        });
    }

    public void initializeOnScrollForRecyclerView() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int pastVisiblesItems = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                if (!isLoading) {
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        isLoading = true;
                        mPostPresenter.loadPosts(false);
                    }
                }
            }
        });
    }
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setVisibility(View.INVISIBLE);
    }

    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    public void displayErrorSnackbar() {
        final View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                mPostPresenter.loadPosts(false);
            }
        };
        final View coordinatorLayoutView = findViewById(R.id.snackbar_position);
        Snackbar
                .make(coordinatorLayoutView, R.string.error_load_post_text, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_action_retry, clickListener)
                .show();
    }

    public void addPosts(List<Post> posts) {
        mPostAdapter.addAllData(posts);
        mPostAdapter.notifyDataSetChanged();
        isLoading = false;
    }

    public void refreshPosts(List<Post> posts) {
        mPostAdapter.clearData();
        mPostAdapter.addAllData(posts);
        mPostAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
        isLoading = false;
    }

}
