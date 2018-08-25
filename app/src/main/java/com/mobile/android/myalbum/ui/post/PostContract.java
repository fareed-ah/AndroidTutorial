package com.mobile.android.myalbum.ui.post;

import com.mobile.android.myalbum.model.post.Post;

import java.util.List;

public interface PostContract {

    interface View {
        void displayPosts(List<Post> postList);
        void displayError(String message);
    }

    interface Presenter {
        void getPosts();
    }
}
