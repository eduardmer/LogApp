package com.hiltproject.utils;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
public class DateFormatter {

    @SuppressLint("SimpleDateFormat")
    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    @Inject
    public DateFormatter(){ }

    public String formatDate(Long time){
        return dateFormat.format(new Date(time));
    }

}
