package com.hiltproject.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = LogEntity.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LogDao getLogDao();

}
