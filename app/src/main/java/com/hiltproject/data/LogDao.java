package com.hiltproject.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface LogDao {

    @Insert
    void insertLog(LogEntity log);

    @Query("SELECT * FROM logstable")
    Flowable<List<LogEntity>> getAllLogs();

    @Query("DELETE FROM logstable")
    void deleteAllLogs();

}
