package com.mobile.android.myalbum.ui.album;

import com.mobile.android.myalbum.model.album.Album;

import java.util.List;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public interface AlbumContract {

    interface View {
        void displayError(String message);

        void displayAlbums(List<Album> myAlbums);

        void navigateToPhotoScreen(int albumId);
    }

    interface Presenter {
        void getAlbums();

        void onAlbumClicked(Album selectedAlbum);

        void setView(AlbumContract.View view);

        void close();
    }
}
