package com.mobile.android.myalbum.ui.photo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobile.android.myalbum.BaseDaggerFragment;
import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.photo.Photo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PhotoFragment extends BaseDaggerFragment implements PhotoContract.View {

    public static final String EXTRA_ALBUM_ID = "albumID";

    @BindView(R.id.fragmentRecyclerView)
    RecyclerView photoRecyclerView;

    @Inject
    PhotoContract.Presenter presenter;

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
        requireActivity().setTitle("Photos");
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            int albumId = getArguments().getInt(EXTRA_ALBUM_ID, 0);
            presenter.getPhotos(albumId);
        }
    }

    @Override
    public void displayPhotos(List<Photo> photos) {
        photoRecyclerView.setAdapter(new PhotoAdapter(photos));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.close();
    }
}
