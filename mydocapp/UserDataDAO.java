package com.example.mydocapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDataDAO {
    @Insert
    void insert(UserData... userdata);

    @Query("select * from userdata")
    List<UserData> getAll();

    @Query("select * from userdata where userid like :name")
    List<UserData> findByName(String name);

    @Query("select * from userdata where uid like :uid")
    UserData findById(int uid);

    @Update
    void updateAll(UserData... userid);

    @Delete
    void delete(UserData userid);
}
