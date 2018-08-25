package com.mobile.android.myalbum.ui.post;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.databinding.ItemPostBinding;
import com.mobile.android.myalbum.model.post.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> listData;

    public PostAdapter(List<Post> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
