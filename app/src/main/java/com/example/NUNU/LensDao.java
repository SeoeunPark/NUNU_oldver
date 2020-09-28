package com.example.NUNU;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface LensDao {


    //@Query 사용하여 쿼리문 작성하기


    @Insert
    void insert(LensInfo lensInfo);

    @Update
    void update(LensInfo lensInfo);

    @Delete
    void delete(LensInfo lensInfo);

}
