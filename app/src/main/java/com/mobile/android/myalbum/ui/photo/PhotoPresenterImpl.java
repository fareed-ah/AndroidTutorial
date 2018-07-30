package com.mobile.android.myalbum.ui.photo;

import android.util.Log;

import com.mobile.android.myalbum.model.photo.Photo;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PhotoPresenterImpl implements PhotoContract.Presenter {

    private PhotoContract.View view;
    private NetworkManager networkManager;

    public PhotoPresenterImpl(PhotoContract.View view, NetworkManager networkManager) {
        this.view = view;
        this.networkManager = networkManager;
    }

    @Override
    public void getPhotos(int albumId) {
        networkManager.getPhotos(albumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Photo>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(List<Photo> photos) {
                        view.displayPhotos(photos);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.d("Error", "onError: " + error.getMessage());
                    }
                });
    }
}
