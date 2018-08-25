package com.mobile.android.myalbum.network;

import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.model.post.Post;
import com.mobile.android.myalbum.model.user.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public interface AlbumService {
    @GET("albums")
    Single<List<Album>> getAlbums();

    @GET("photos")
    Single<List<Photo>> getPhotos(@Query("albumId") int albumId);

    @GET("users")
    Single<List<User>> getUsers();

    @GET("posts")
    Single<List<Post>> getPosts();
}
