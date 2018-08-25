package com.mobile.android.myalbum.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.model.post.Post;
import com.mobile.android.myalbum.model.user.User;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public class NetworkManager {
    private AlbumService albumAPI = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(AlbumService.class);

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
