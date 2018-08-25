package com.mobile.android.myalbum.ui.post;

import com.mobile.android.myalbum.model.post.Post;
import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PostPresenterImpl implements PostContract.Presenter {

    private NetworkManager networkManager;
    private PostContract.View view;
    private Scheduler backgroundScheduler, mainScheduler;

    public PostPresenterImpl(NetworkManager networkManager, PostContract.View view,
                             Scheduler backgroundScheduler, Scheduler mainScheduler) {
        this.networkManager = networkManager;
        this.view = view;
        this.backgroundScheduler = backgroundScheduler;
        this.mainScheduler = mainScheduler;
    }

    @Override
    public void getPosts() {
        networkManager.getPosts()
                .subscribeOn(backgroundScheduler)
                .observeOn(mainScheduler)
                .subscribe(new SingleObserver<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onSuccess(List<Post> posts) {
                        view.displayPosts(posts);
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.displayError(error.getMessage());
                    }
                });
    }
}
