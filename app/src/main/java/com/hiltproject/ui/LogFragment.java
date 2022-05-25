package com.hiltproject.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hiltproject.R;
import com.hiltproject.data.LoggerRepository;
import com.hiltproject.databinding.FragmentLogBinding;
import java.util.ArrayList;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@AndroidEntryPoint
public class LogFragment extends Fragment {

    FragmentLogBinding binding;
    final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject LoggerRepository logger;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        LogAdapter adapter = new LogAdapter(this, new ArrayList<>());
        binding.recyclerView.setAdapter(adapter);
        compositeDisposable.add(logger.getAllLogs().observeOn(AndroidSchedulers.mainThread()).subscribe(
                adapter::updateLogs,
                error -> Log.i("pergjigja", error.toString())
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