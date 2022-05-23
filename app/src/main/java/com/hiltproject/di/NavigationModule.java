package com.hiltproject.di;

import com.hiltproject.navigator.AppNavigator;
import com.hiltproject.navigator.AppNavigatorImpl;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@InstallIn(ActivityComponent.class)
@Module
abstract class NavigationModule {

    @Binds
    abstract AppNavigator bind(AppNavigatorImpl appNavigator);

}
