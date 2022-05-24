package com.hiltproject.di;

import com.hiltproject.data.LoggerRepository;
import com.hiltproject.data.LoggerRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@InstallIn(ActivityComponent.class)
@Module
public abstract class LoggingModule {

    @ActivityScoped
    @Binds
    abstract LoggerRepository bindLogger(LoggerRepositoryImpl loggerRepository);

}
