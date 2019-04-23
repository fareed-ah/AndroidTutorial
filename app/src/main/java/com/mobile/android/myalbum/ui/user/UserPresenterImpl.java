package com.mobile.android.myalbum.ui.user;

import com.mobile.android.myalbum.database.UserEntity;
import com.mobile.android.myalbum.database.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class UserPresenterImpl implements UserContract.Presenter {

    private UserContract.View view;
    private Scheduler backgroundScheduler;
    private Scheduler mainScheduler;
    private UserRepository userRepository;
    private CompositeDisposable compositeDisposable;

    @Inject
    public UserPresenterImpl(UserContract.View view,
                             Scheduler backgroundScheduler,
                             Scheduler mainScheduler,
                             UserRepository userRepository) {
        this.view = view;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        this.userRepository = userRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getUsers() {
        userRepository.getUsers()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<UserEntity>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(List<UserEntity> userEntities) {
                        view.displayUsers(userEntities);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.displayError(error.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void setView(UserContract.View view) {
        this.view = view;
    }

    @Override
    public void close() {
        view = null;
        compositeDisposable.clear();
    }
}
