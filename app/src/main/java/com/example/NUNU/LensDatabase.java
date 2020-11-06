package com.example.NUNU;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 5 ,exportSchema = false)
public abstract class LensDatabase extends RoomDatabase {

    public abstract LensDao lensDao();

    private static  LensDatabase INSTANCE;

    //싱글톤
    public static LensDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LensDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LensDatabase.class, "lens_database").fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}