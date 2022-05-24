package com.hiltproject.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.hiltproject.R;
import com.hiltproject.data.LogEntity;
import com.hiltproject.databinding.LogItemBinding;
import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.CustomViewHolder> {

    final List<LogEntity> logs;

    public LogAdapter(List<LogEntity> logs){
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
        holder.bind(log.getMessage());
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
