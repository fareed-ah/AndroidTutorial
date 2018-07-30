package com.mobile.android.myalbum.ui.album;

import com.mobile.android.myalbum.model.album.Album;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fareed Ahmad on 2018-07-27.
 */

public class AlbumPresenterImpl implements AlbumContract.Presenter {

    private NetworkManager networkManager;
    private AlbumContract.View view;
    private CompositeDisposable compositeDisposable;
    private Scheduler backgroundScheduler;
    private Scheduler mainScheduler;

    public AlbumPresenterImpl(AlbumContract.View view,
                              NetworkManager networkManager,
                              Scheduler backgroundScheduler,
                              Scheduler mainScheduler) {
        this.networkManager = networkManager;
        this.view = view;
        this.mainScheduler = mainScheduler;
        this.backgroundScheduler = backgroundScheduler;

        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getAlbums() {
        networkManager.getAlbums()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<Album>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(List<Album> albums) {
                        if (view != null) {
                            view.displayAlbums(albums);
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        if(view != null) {
                            view.displayError(error.getMessage());
                        }
                    }
                });
    }

    @Override
    public void onAlbumClicked(Album selectedAlbum) {
        if (view != null) {
            view.navigateToPhotoScreen(selectedAlbum.getId());
        }
    }

    @Override
    public void setView(AlbumContract.View newView) {
        view = newView;
    }

    @Override
    public void close() {
        view = null;
        compositeDisposable.clear();
    }
}
