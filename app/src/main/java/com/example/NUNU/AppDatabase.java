package com.example.NUNU;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {UserInfo.class,LensInfo.class}, version = 4, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao UserDao(); //UserDao 인터페이스
    public abstract LensDao LensDao(); //LensDao 인터페이스
}
