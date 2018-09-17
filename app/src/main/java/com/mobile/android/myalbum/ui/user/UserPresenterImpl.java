package com.mobile.android.myalbum.ui.user;

import com.mobile.android.myalbum.database.UserEntity;
import com.mobile.android.myalbum.database.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class UserPresenterImpl implements UserContract.Presenter {

    private UserContract.View view;
    private Scheduler backgroundScheduler;
    private Scheduler mainScheduler;
    private UserRepository userRepository;

    @Inject
    public UserPresenterImpl(UserContract.View view,
                             Scheduler backgroundScheduler,
                             Scheduler mainScheduler,
                             UserRepository userRepository) {
        this.view = view;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        this.userRepository = userRepository;
    }

    @Override
    public void getUsers() {
        userRepository.getUsers()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<UserEntity>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(List<UserEntity> userEntities) {
                        view.displayUsers(userEntities);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.displayError("Could not fetch data from the database");
                    }
                });
    }
}
