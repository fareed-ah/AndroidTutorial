package com.mobile.android.myalbum.ui.user.dagger;

import com.mobile.android.myalbum.network.NetworkManager;
import com.mobile.android.myalbum.ui.user.UserContract;
import com.mobile.android.myalbum.ui.user.UserFragment;
import com.mobile.android.myalbum.ui.user.UserPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public abstract class UserPresenterModule {

    @Binds
    abstract UserContract.View bindUserView(UserFragment fragment);

    @Provides
    public static UserContract.Presenter providesUserPresenter(UserContract.View view, NetworkManager networkManager){
        return new UserPresenterImpl(view,networkManager, Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
