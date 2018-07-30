package com.mobile.android.myalbum.ui.photo;

import android.support.v7.widget.RecyclerView;

import com.mobile.android.myalbum.databinding.ItemPhotoBinding;
import com.mobile.android.myalbum.model.photo.Photo;

public class PhotoViewHolder extends RecyclerView.ViewHolder {
    private ItemPhotoBinding binding;

    public PhotoViewHolder(ItemPhotoBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(Photo photo) {
        binding.setPhoto(photo);
        binding.executePendingBindings();
    }
}
