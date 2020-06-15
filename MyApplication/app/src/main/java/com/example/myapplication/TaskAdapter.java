package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.example.myapplication.R.drawable.ic_cancel_black_24dp;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    LayoutInflater inflater;
    List<Task> tasks;

    public TaskAdapter(Context context, List<Task> list)
    {
        this.inflater = LayoutInflater.from(context);
        this.tasks = list;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.task_list_layout, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        holder.txtTask.setText(tasks.get(position).getTask());
        holder.txtTaskGiver.setText(tasks.get(position).getTask_giver());
        if(tasks.get(position).getTask_status() == 0)
        {
            holder.txtTaskStatus.setText("Not yet finished");
            holder.txtTaskStatus.setTextColor(Color.RED);
        }else
        {
            holder.txtTaskStatus.setText("Finished");
            holder.txtTaskStatus.setTextColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder
    {
        TextView txtTask, txtTaskGiver, txtTaskStatus;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            txtTask = itemView.findViewById(R.id.txtTask);
            txtTaskGiver = itemView.findViewById(R.id.txtTaskGiver);
            txtTaskStatus = itemView.findViewById(R.id.txtTaskStatus);
        }
    }

}
