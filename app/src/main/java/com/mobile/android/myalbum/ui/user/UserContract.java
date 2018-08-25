package com.mobile.android.myalbum.ui.user;

import com.mobile.android.myalbum.model.user.User;

import java.util.List;

public interface UserContract {

    interface View {
        void displayUsers(List<User> users);
        void displayError(String message);
    }

    interface Presenter {
        void getUsers();
    }
}
