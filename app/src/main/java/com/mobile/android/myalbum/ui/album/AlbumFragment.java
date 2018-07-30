package com.mobile.android.myalbum.ui.album;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.network.NetworkManager;
import com.mobile.android.myalbum.ui.photo.PhotoFragment;

import java.util.List;

public class AlbumFragment extends Fragment implements AlbumContract.View {

    private AlbumPresenterImpl presenter;
    private AlbumAdapter albumAdapter;
    private RecyclerView albumRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Album");
        }
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        albumRecyclerView = view.findViewById(R.id.fragmentRecyclerView);
        albumRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        presenter = new AlbumPresenterImpl(this, new NetworkManager());
        presenter.getAlbums();
    }

    @Override
    public void displayAlbums(List<Album> myAlbums) {
        albumAdapter = new AlbumAdapter(myAlbums, presenter);
        albumRecyclerView.setAdapter(albumAdapter);
    }

    @Override
    public void navigateToPhotoScreen(int albumId) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PhotoFragment photoFragment = PhotoFragment.newInstance(albumId);
        fragmentTransaction.replace(R.id.fragmentContainer, photoFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
