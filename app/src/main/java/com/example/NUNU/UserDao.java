package com.example.NUNU;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM UserInfo")
    List<UserInfo> getAll();

    @Insert
    void insert(UserInfo todo);

    @Update
    void update(UserInfo todo);

    @Delete
    void delete(UserInfo todo);

    @Query("DELETE FROM UserInfo")
    void deleteAll();

}
