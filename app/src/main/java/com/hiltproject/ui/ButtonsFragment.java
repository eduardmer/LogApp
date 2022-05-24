package com.hiltproject.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hiltproject.R;
import com.hiltproject.data.LoggerRepository;
import com.hiltproject.databinding.FragmentButtonsBinding;
import com.hiltproject.navigator.AppNavigator;
import com.hiltproject.navigator.Screens;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@AndroidEntryPoint
public class ButtonsFragment extends Fragment {

    @Inject LoggerRepository logger;
    @Inject AppNavigator navigator;
    FragmentButtonsBinding binding;
    final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ButtonsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buttons, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button1.setOnClickListener(v -> observeLogger(logger.addLog("Interaction with 'Button 1'")));
        binding.button2.setOnClickListener(v -> observeLogger(logger.addLog("Interaction with 'Button 2'")));
        binding.button3.setOnClickListener(v -> observeLogger(logger.addLog("Interaction with 'Button 3'")));
        binding.seeLogsButton.setOnClickListener(v -> navigator.navigateTo(Screens.LOGS));
        binding.deleteButton.setOnClickListener(v -> observeLogger(logger.deleteAllLogs()));

    }

    public void observeLogger(Completable observable){
        compositeDisposable.add(observable.observeOn(AndroidSchedulers.mainThread()).subscribe(
                () -> Log.i("pergjigja", "Sukses"),
                e -> Log.i("pergjigja", e.toString())
        ));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        compositeDisposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}