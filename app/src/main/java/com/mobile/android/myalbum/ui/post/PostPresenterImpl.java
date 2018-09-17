package com.mobile.android.myalbum.ui.post;

import com.mobile.android.myalbum.model.post.Post;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class PostPresenterImpl implements PostContract.Presenter {

    private NetworkManager networkManager;
    private PostContract.View view;
    private Scheduler backgroundScheduler, mainScheduler;
    private CompositeDisposable compositeDisposable;

    @Inject
    public PostPresenterImpl(PostContract.View view, NetworkManager networkManager,
                             Scheduler backgroundScheduler, Scheduler mainScheduler) {
        this.networkManager = networkManager;
        this.view = view;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getPosts() {
        networkManager.getPosts()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(List<Post> posts) {
                        if (view != null) {
                            view.displayPosts(posts);
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
    public void setView(PostContract.View view) {
        this.view = view;
    }

    @Override
    public void close() {
        view = null;
        compositeDisposable.clear();
    }
}
