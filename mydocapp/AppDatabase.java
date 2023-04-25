package com.example.mydocapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserData.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract UserDataDAO userdataDAO();
    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,"AppDatabase.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
