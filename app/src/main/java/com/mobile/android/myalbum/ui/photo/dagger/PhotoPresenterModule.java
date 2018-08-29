package com.mobile.android.myalbum.ui.photo.dagger;

import com.mobile.android.myalbum.network.NetworkManager;
import com.mobile.android.myalbum.ui.photo.PhotoContract;
import com.mobile.android.myalbum.ui.photo.PhotoFragment;
import com.mobile.android.myalbum.ui.photo.PhotoPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public abstract class PhotoPresenterModule {

    @Binds
    abstract PhotoContract.View bindPhotoView(PhotoFragment fragment);

    @Provides
    public static PhotoContract.Presenter providesPhotoPresenter(PhotoContract.View view, NetworkManager networkManager) {
        return new PhotoPresenterImpl(view, networkManager, Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
