package com.hiltproject;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    public AppDatabase getAppDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "AppDatabase").build();
    }

    public LogDao logDao(AppDatabase database){
        return database.getLogDao();
    }

}
