package com.mobile.android.myalbum.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 1, entities = {UserEntity.class})
public abstract class UserDatabase extends RoomDatabase {
        public abstract UserDao userDao();
}
