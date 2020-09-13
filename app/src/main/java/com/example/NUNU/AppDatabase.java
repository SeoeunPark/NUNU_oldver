package com.example.NUNU;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserInfo.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    //public abstract UserDao userInfo(); // Dao 인터페이스

    public abstract UserDao UserDao();
}
