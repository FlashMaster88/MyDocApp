package com.example.mydocapp;

import android.content.Context;

import java.util.List;

public class Singleton {

    private static Singleton instance = new Singleton();
    private List<UserData> users;
    Context context;
    UserDataDAO userdataDAO;

    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }

    public void setContext(Context context){
        this.context = context;
        userdataDAO = AppDatabase.getInstance(context).userdataDAO();
        users = userdataDAO.getAll();
    }
    public List<UserData> getUsers(){
        return users;
    }
    public void addUser(UserData user){
        userdataDAO.insert(user);
        users = userdataDAO.getAll();
    }
    public void updateUser(UserData user){
        userdataDAO.updateAll(user);
        users = userdataDAO.getAll();
    }
    public void deleteUser(int userPosition){
        UserData c = users.get(userPosition);
        userdataDAO.delete(c);
        users = userdataDAO.getAll();
    }
}
