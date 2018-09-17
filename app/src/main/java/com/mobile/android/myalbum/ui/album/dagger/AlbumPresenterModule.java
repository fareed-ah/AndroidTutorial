package com.mobile.android.myalbum.ui.album.dagger;

import com.mobile.android.myalbum.network.NetworkManager;
import com.mobile.android.myalbum.ui.album.AlbumContract;
import com.mobile.android.myalbum.ui.album.AlbumFragment;
import com.mobile.android.myalbum.ui.album.AlbumPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public abstract class AlbumPresenterModule {

    @Binds
    abstract AlbumContract.View bindsAlbumView(AlbumFragment fragment);

    @Provides
    public static AlbumContract.Presenter providesAlbumPresenter(AlbumContract.View view, NetworkManager networkManager) {
        return new AlbumPresenterImpl(view, networkManager, Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
