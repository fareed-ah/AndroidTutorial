package com.mobile.android.myalbum.ui.user.dagger;

import com.mobile.android.myalbum.database.UserDatabase;
import com.mobile.android.myalbum.database.UserRepository;
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
    public static UserRepository providesUserRepository(NetworkManager networkManager, UserDatabase userDatabase) {
        return new UserRepository(networkManager,userDatabase);
    }

    @Provides
    public static UserContract.Presenter providesUserPresenter(UserContract.View view, UserRepository userRepository) {
        return new UserPresenterImpl(view, Schedulers.io(), AndroidSchedulers.mainThread(), userRepository);
    }
}
