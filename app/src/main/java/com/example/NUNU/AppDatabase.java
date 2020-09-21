package com.example.NUNU;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserInfo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDao(); //Dao 인터페이스
}
