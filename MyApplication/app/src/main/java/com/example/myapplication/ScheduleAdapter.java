package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    Context context;
    LayoutInflater inflater;
    List<Schedule> schedules;

    public ScheduleAdapter(Context context, List<Schedule> list)
    {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.schedules = list;
    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.schedule_list_layout, parent, false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScheduleHolder holder, int position) {
        holder.txtSchedule.setText(schedules.get(position).getSchedule());
        holder.txtScheduleTeacher.setText(schedules.get(position).getSchedule_teacher());
        if(schedules.get(position).getSchedule_status() == 0)
        {
            holder.txtScheduleAvailability.setText("Not Available");
            holder.txtScheduleAvailability.setTextColor(Color.RED);
        }else
        {
            holder.txtScheduleAvailability.setText("Available");
        }

        holder.cardSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is " + holder.txtSchedule.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class ScheduleHolder extends RecyclerView.ViewHolder
    {
        TextView txtSchedule, txtScheduleTeacher, txtScheduleAvailability;
        CardView cardSchedule;
        public ScheduleHolder(@NonNull View itemView) {
            super(itemView);
            txtSchedule = itemView.findViewById(R.id.txtSchedule);
            txtScheduleTeacher = itemView.findViewById(R.id.txtScheduleTeacher);
            txtScheduleAvailability = itemView.findViewById(R.id.txtScheduleStatus);
            cardSchedule = itemView.findViewById(R.id.cardSchedule);
        }
    }

}
