package com.mobile.android.myalbum.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.mobile.android.myalbum.model.user.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertUser(UserEntity user);

    @Delete
    abstract void deleteUsers(List<UserEntity> users);

    @Query("SELECT * FROM users")
    abstract Single<List<UserEntity>> loadAllUsers();

    @Transaction
    public void insertUsers(List<User> users) {
        for (User user : users) {
            UserEntity userEntity = new UserEntity(user);
            insertUser(userEntity);
        }
    }
}
