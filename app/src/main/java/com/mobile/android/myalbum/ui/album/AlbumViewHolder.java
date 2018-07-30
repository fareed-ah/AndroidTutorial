package com.mobile.android.myalbum.ui.album;

import android.support.v7.widget.RecyclerView;

import com.mobile.android.myalbum.databinding.ItemAlbumBinding;
import com.mobile.android.myalbum.model.album.Album;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    private ItemAlbumBinding binding;
    private AlbumContract.Presenter presenter;

    public AlbumViewHolder(ItemAlbumBinding binding, AlbumContract.Presenter presenter) {
        super(binding.getRoot());
        this.binding = binding;
        this.presenter = presenter;
    }

    public void onBind(Album myAlbum) {
        binding.setAlbum(myAlbum);
        binding.setPresenter(presenter);
        binding.executePendingBindings();
    }
}
