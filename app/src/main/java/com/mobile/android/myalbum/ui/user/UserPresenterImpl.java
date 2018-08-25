package com.mobile.android.myalbum.ui.user;

import android.util.Log;

import com.mobile.android.myalbum.model.user.User;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserPresenterImpl implements UserContract.Presenter {

    private UserContract.View view;
    private NetworkManager networkManager;
    private Scheduler backgroundScheduler;
    private Scheduler mainScheduler;

    public UserPresenterImpl(UserContract.View view,
                             NetworkManager networkManager,
                             Scheduler backgroundScheduler,
                             Scheduler mainScheduler) {
        this.view = view;
        this.networkManager = networkManager;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
    }

    @Override
    public void getUsers() {
        networkManager.getUsers()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        view.displayUsers(users);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.displayError(error.getMessage());
                    }
                });
    }
}
