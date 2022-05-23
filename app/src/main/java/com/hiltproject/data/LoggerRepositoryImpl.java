package com.hiltproject.data;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoggerRepositoryImpl implements LoggerRepository{

    final LogDao logDao;

    @Inject
    public LoggerRepositoryImpl(LogDao logDao){
        this.logDao = logDao;
    }

    @Override
    public Completable addLog(String message) {
        return Completable.fromAction(() -> logDao.insertLog(new LogEntity(message, System.currentTimeMillis()))).subscribeOn(Schedulers.io());
    }

    @Override
    public Flowable<List<LogEntity>> getAllLogs() {
        return logDao.getAllLogs();
    }

    @Override
    public Completable deleteAllLogs() {
        return Completable.fromAction(logDao::deleteAllLogs).subscribeOn(Schedulers.io());
    }
}
