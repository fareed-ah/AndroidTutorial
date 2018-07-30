package com.mobile.android.myalbum.ui.photo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

public class PhotoFragment extends Fragment implements PhotoContract.View {

    public static final String EXTRA_ALBUM_ID = "albumID";
    private PhotoContract.Presenter presenter;
    private RecyclerView photoRecyclerView;

    public static PhotoFragment newInstance(int albumId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_ALBUM_ID, albumId);

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        if(activity != null){
            activity.setTitle("Photos");
        }
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new PhotoPresenterImpl(this, new NetworkManager());
        photoRecyclerView = view.findViewById(R.id.fragmentRecyclerView);
        if (getArguments() != null) {
            int albumId = getArguments().getInt(EXTRA_ALBUM_ID, 0);
            presenter.getPhotos(albumId);
        }
    }

    @Override
    public void displayPhotos(List<Photo> photos) {
        photoRecyclerView.setAdapter(new PhotoAdapter(photos));
    }
}
