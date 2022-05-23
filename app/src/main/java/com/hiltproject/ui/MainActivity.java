package com.hiltproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.hiltproject.R;
import com.hiltproject.navigator.AppNavigator;
import com.hiltproject.navigator.Screens;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    AppNavigator appNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appNavigator.navigateTo(Screens.BUTTONS);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
            finish();
    }
}