package com.mobile.android.myalbum.database;

import com.mobile.android.myalbum.network.NetworkManager;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserRepository {

    private NetworkManager networkManager;
    private UserDatabase userDatabase;

    @Inject
    public UserRepository(NetworkManager networkManager, UserDatabase userDatabase) {
        this.networkManager = networkManager;
        this.userDatabase = userDatabase;
    }

    public Single<List<UserEntity>> getUsers() {
        return userDatabase.userDao().loadAllUsers()
                .flatMap(userEntities -> {
                    if (userEntities.isEmpty()) {
                        return networkManager.getUsers().flatMap(users -> {
                            userDatabase.userDao().insertUsers(users);
                            return userDatabase.userDao().loadAllUsers();
                        });
                    }
                    return Single.just(userEntities);
                });
    }
}
