package com.mobile.android.myalbum.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mobile.android.myalbum.MainApplication;
import com.mobile.android.myalbum.database.UserDatabase;
import com.mobile.android.myalbum.network.AlbumService;
import com.mobile.android.myalbum.network.NetworkManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class AppModule {

    @Binds
    public abstract Context bindsApplicationContext(MainApplication application);

    @Provides
    @Singleton
    public static NetworkManager providesNetworkManager() {
        AlbumService albumAPI = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AlbumService.class);

        return new NetworkManager(albumAPI);
    }

    @Provides
    @Singleton
    public static UserDatabase providesUserDatabase(Context context) {
        return Room.databaseBuilder(context, UserDatabase.class, "user-database")
                .fallbackToDestructiveMigration()
                .build();
    }
}
