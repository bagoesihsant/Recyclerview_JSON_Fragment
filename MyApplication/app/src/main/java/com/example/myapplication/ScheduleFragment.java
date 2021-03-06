package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ScheduleFragment extends Fragment {

    private final String URL_SCHEDULE = "http://192.168.43.132/AndroidTest/schedules.php";
    private RecyclerView recyclerView;
    private List<Schedule> schedules;
    private ScheduleAdapter adapter;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = view.findViewById(R.id.recyclerSchedule);
        schedules = new ArrayList<>();

        extractSchedules();

        return view;
    }

    private void extractSchedules()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, URL_SCHEDULE, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Schedule schedule = new Schedule();
                                schedule.setSchedule(jsonObject.getString("schedule"));
                                schedule.setSchedule_teacher(jsonObject.getString("schedule_teacher"));
                                schedule.setSchedule_status(jsonObject.getInt("schedule_status"));
                                schedule.setSchedule_id(jsonObject.getInt("id_schedule"));
                                schedules.add(schedule);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity().getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                        adapter = new ScheduleAdapter(getActivity().getApplicationContext(), schedules);
                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonRequest);
    }

}
