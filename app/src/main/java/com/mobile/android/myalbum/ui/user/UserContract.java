package com.mobile.android.myalbum.ui.user;

import com.mobile.android.myalbum.database.UserEntity;

import java.util.List;

public interface UserContract {

    interface View {
        void displayUsers(List<UserEntity> users);
        void displayError(String message);
    }

    interface Presenter {
        void getUsers();
    }
}
