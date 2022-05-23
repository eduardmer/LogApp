package com.hiltproject.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LogsTable")
public class LogEntity {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String message;
    private long time;

    public LogEntity(String message, long time){
        this.message = message;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
