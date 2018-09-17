package com.mobile.android.myalbum.ui.album;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobile.android.myalbum.BaseDaggerFragment;
import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.ui.photo.PhotoFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class AlbumFragment extends BaseDaggerFragment implements AlbumContract.View {

    private AlbumAdapter albumAdapter;

    @BindView(R.id.fragmentRecyclerView)
    RecyclerView albumRecyclerView;

    @Inject
    AlbumContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        requireActivity().setTitle("Album");
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        albumRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        presenter.getAlbums();
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
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
