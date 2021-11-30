package com.juanagui.room;

import android.app.Application;

import com.juanagui.room.db.AppDatabase;

public class RoomApplication extends Application {
    //Only purpose for this class is saving a reference to the DB
    public AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        //Creates a DB object accessible to all elements on main activity
        appDatabase = AppDatabase.getInstance(this);
    }
}