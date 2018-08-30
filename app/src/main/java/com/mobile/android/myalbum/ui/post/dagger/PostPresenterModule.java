package com.mobile.android.myalbum.ui.post.dagger;

import com.mobile.android.myalbum.network.NetworkManager;
import com.mobile.android.myalbum.ui.post.PostContract;
import com.mobile.android.myalbum.ui.post.PostFragment;
import com.mobile.android.myalbum.ui.post.PostPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public abstract class PostPresenterModule {

    @Binds
    abstract PostContract.View bindPostView(PostFragment fragment);

    @Provides
    public static PostContract.Presenter providesPostPresenter(PostContract.View view, NetworkManager networkManager) {
        return new PostPresenterImpl(view, networkManager, Schedulers.io(), AndroidSchedulers.mainThread());
    }
}
