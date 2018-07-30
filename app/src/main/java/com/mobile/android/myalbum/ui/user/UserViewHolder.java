package com.mobile.android.myalbum.ui.user;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobile.android.myalbum.databinding.ItemUserBinding;
import com.mobile.android.myalbum.model.user.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private ItemUserBinding binding;

    public UserViewHolder(ItemUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void onBind(User user){
        binding.setUser(user);
        binding.executePendingBindings();
    }
}
