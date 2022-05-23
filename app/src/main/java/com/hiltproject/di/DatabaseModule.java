package com.hiltproject.di;

import android.content.Context;
import androidx.room.Room;
import com.hiltproject.data.AppDatabase;
import com.hiltproject.data.LogDao;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Singleton
    @Provides
    public AppDatabase getAppDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context, AppDatabase.class, "AppDatabase").build();
    }

    @Provides
    public LogDao logDao(AppDatabase database){
        return database.getLogDao();
    }

}
