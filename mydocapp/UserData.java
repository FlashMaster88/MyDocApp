package com.example.mydocapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserData {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "userid")
    public String userid;
    @ColumnInfo(name = "password")
    public String password;

    public UserData(){

    }

    public UserData(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }
}
