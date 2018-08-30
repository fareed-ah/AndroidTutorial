package com.mobile.android.myalbum.ui.album;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.android.myalbum.databinding.ItemAlbumBinding;
import com.mobile.android.myalbum.model.album.Album;

import java.util.List;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {
    private List<Album> myAlbums;
    private AlbumContract.Presenter presenter;

    public AlbumAdapter(List<Album> myAlbums, AlbumContract.Presenter presenter) {
        this.myAlbums = myAlbums;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AlbumViewHolder(binding, presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.onBind(myAlbums.get(position));
    }

    @Override
    public int getItemCount() {
        return myAlbums.size();
    }
}
