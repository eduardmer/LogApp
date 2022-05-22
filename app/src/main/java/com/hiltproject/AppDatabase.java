package com.hiltproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = LogEntity.class, version = 1)
abstract class AppDatabase extends RoomDatabase {

    abstract LogDao getLogDao();

}
