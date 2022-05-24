package com.hiltproject.data;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface LoggerRepository {

    Completable addLog(String message);

    Flowable<List<LogEntity>> getAllLogs();

    Completable deleteAllLogs();

}
