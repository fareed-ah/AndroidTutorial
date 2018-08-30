package com.mobile.android.myalbum.network;

import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.model.post.Post;
import com.mobile.android.myalbum.model.user.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public class NetworkManager {

    private AlbumService albumAPI;

    @Inject
    public NetworkManager(AlbumService albumAPI) {
        this.albumAPI = albumAPI;
    }

    public Single<List<Album>> getAlbums() {
        return albumAPI.getAlbums();
    }

    public Single<List<Photo>> getPhotos(int albumId) {
        return albumAPI.getPhotos(albumId);
    }

    public Single<List<User>> getUsers() {
        return albumAPI.getUsers();
    }

    public Single<List<Post>> getPosts() {
        return albumAPI.getPosts();
    }
}
