package com.fullscreen.demo.popular.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fullscreen.demo.popular.R;
import com.fullscreen.demo.popular.activities.PlayerActivity;
import com.fullscreen.demo.popular.models.Post;
import com.fullscreen.demo.popular.utils.CircleTransform;
import com.fullscreen.demo.popular.utils.Constants;
import com.fullscreen.demo.popular.widgets.PhotoFitView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by datct0407 on 10/6/15.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<Post> posts;
    private Context mContext;

    public PostAdapter(Context context, List<Post> posts) {
        this.mContext = context;
        this.posts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.userNameTv.setText(post.getUser().getFullName());
        if (post.getType().equalsIgnoreCase(Constants.POST_TYPE_IMAGE)) {
            holder.videoPlayIcon.setVisibility(View.GONE);
        } else {
            holder.videoPlayIcon.setVisibility(View.VISIBLE);
        }
        Picasso.with(mContext).load(post.getImages().getStandardResolution().getUrl())
                .error(R.mipmap.small_thumb)
                .placeholder(R.mipmap.small_thumb)
                .into(holder.photoView);

        Picasso.with(mContext).load(post.getUser().getProfilePicture())
                .transform(new CircleTransform())
                .error(R.mipmap.small_thumb)
                .placeholder(R.mipmap.small_thumb)
                .into(holder.userPhoto);
        holder.videoPlayIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (post.getType().equalsIgnoreCase(Constants.POST_TYPE_VIDEO)) {
                    String url = post.getVideos().getStandardResolution().getUrl();
                    startPlayVideoByUrl(url);
                }
            }
        });
    }

    private void startPlayVideoByUrl(String url) {
        Intent mpdIntent = new Intent(mContext, PlayerActivity.class)
                .setData(Uri.parse(url))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, Constants.POST_TYPE_VIDEO)
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, PlayerActivity.TYPE_OTHER);
        mContext.startActivity(mpdIntent);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void clearData() {
        posts.clear();
    }

    public void addAllData(List<Post> posts) {
        this.posts.addAll(posts);
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.insta_photo)
        ImageView photoView;

        @InjectView(R.id.video_play_icon)
        ImageView videoPlayIcon;

        @InjectView(R.id.user_photo)
        ImageView userPhoto;

        @InjectView(R.id.user_name)
        TextView userNameTv;

        public PostViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
