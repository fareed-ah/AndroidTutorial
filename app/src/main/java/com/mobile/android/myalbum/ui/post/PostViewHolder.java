package com.mobile.android.myalbum.ui.post;

import android.support.v7.widget.RecyclerView;

import com.mobile.android.myalbum.databinding.ItemPostBinding;
import com.mobile.android.myalbum.model.post.Post;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private ItemPostBinding binding;

    public PostViewHolder(ItemPostBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Post post) {
        binding.setPost(post);
        binding.executePendingBindings();
    }
}
