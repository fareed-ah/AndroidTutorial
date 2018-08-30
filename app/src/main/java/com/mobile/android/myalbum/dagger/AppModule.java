package com.mobile.android.myalbum.dagger;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mobile.android.myalbum.network.AlbumService;
import com.mobile.android.myalbum.network.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    public NetworkManager providesNetworkManager() {
        AlbumService albumAPI = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AlbumService.class);

        return new NetworkManager(albumAPI);
    }
}
