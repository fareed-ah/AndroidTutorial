package com.mobile.android.myalbum.ui.photo;

import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class PhotoPresenterImpl implements PhotoContract.Presenter {

    private PhotoContract.View view;
    private NetworkManager networkManager;
    private Scheduler backgroundScheduler;
    private Scheduler mainScheduler;
    private CompositeDisposable compositeDisposable;

    @Inject
    public PhotoPresenterImpl(PhotoContract.View view,
                              NetworkManager networkManager,
                              Scheduler backgroundScheduler,
                              Scheduler mainScheduler) {
        this.view = view;
        this.networkManager = networkManager;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getPhotos(int albumId) {
        networkManager.getPhotos(albumId)
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<Photo>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(List<Photo> photos) {
                        if (view != null) {
                            view.displayPhotos(photos);
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        if (view != null) {
                            view.displayError(error.getMessage());
                        }
                    }
                });
    }

    @Override
    public void setView(PhotoContract.View view) {
        this.view = view;
    }

    @Override
    public void close() {
        view = null;
        compositeDisposable.clear();
    }
}
