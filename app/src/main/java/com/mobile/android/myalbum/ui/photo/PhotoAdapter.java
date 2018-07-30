package com.mobile.android.myalbum.ui.photo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.android.myalbum.databinding.ItemPhotoBinding;
import com.mobile.android.myalbum.model.photo.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private List<Photo> myPhotos;

    public PhotoAdapter(List<Photo> myPhotos) {
        this.myPhotos = myPhotos;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPhotoBinding binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhotoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.onBind(myPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return myPhotos.size();
    }
}
