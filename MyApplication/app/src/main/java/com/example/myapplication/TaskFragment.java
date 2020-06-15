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


public class TaskFragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private List<Task> tasks;
    private final String URL_TASK = "http://192.168.43.132/AndroidTest/tasks.php";

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        recyclerView = view.findViewById(R.id.recyclerTask);
        tasks = new ArrayList<>();

        extractTasks();

        return view;
    }

    private void extractTasks()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, URL_TASK, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Task task = new Task();
                                task.setTask(jsonObject.getString("task"));
                                task.setTask_giver(jsonObject.getString("giver"));
                                task.setTask_status(jsonObject.getInt("status"));
                                task.setTask_id(jsonObject.getInt("id_task"));
                                tasks.add(task);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity().getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                        adapter = new TaskAdapter(getActivity().getApplicationContext(), tasks);
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
