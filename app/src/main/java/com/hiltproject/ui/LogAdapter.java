package com.hiltproject.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.hiltproject.R;
import com.hiltproject.data.LogEntity;
import com.hiltproject.databinding.LogItemBinding;
import com.hiltproject.utils.DateFormatter;
import java.util.List;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.android.components.FragmentComponent;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.CustomViewHolder> {

    @InstallIn(FragmentComponent.class)
    @EntryPoint
    interface LogAdapterEntryPoint{
        DateFormatter dateFormatter();
    }

    private DateFormatter getDateFormatter(Fragment context){
        return EntryPointAccessors.fromFragment(context, LogAdapterEntryPoint.class).dateFormatter();
    }

    final Fragment fragment;
    final List<LogEntity> logs;

    public LogAdapter(Fragment fragment, List<LogEntity> logs){
        this.fragment = fragment;
        this.logs = logs;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.log_item, parent, false);
        return new CustomViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        LogEntity log = logs.get(position);
        holder.bind(log.getMessage() + "\n" + getDateFormatter(fragment).formatDate(log.getTime()));
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        LogItemBinding binding;

        public CustomViewHolder(@NonNull LogItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String text){
            binding.setText(text);
            binding.executePendingBindings();
        }

    }

    public void updateLogs(List<LogEntity> logs){
        this.logs.clear();
        this.logs.addAll(logs);
        notifyDataSetChanged();
    }

}
