package com.hiltproject.navigator;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hiltproject.R;
import com.hiltproject.ui.ButtonsFragment;
import com.hiltproject.ui.LogFragment;

import javax.inject.Inject;

public class AppNavigatorImpl implements AppNavigator{
    final FragmentActivity activity;

    @Inject
    public AppNavigatorImpl(FragmentActivity activity){
        this.activity = activity;
    }

    @Override
    public void navigateTo(Screens screen) {
        Fragment fragment = screen == Screens.BUTTONS ? new ButtonsFragment() : new LogFragment();
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(fragment.getClass().getCanonicalName())
                .commit();
    }
}
