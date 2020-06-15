package com.example.myapplication;

public class Task {

    private int task_id;
    private String task;
    private int task_status;
    private String task_giver;

    public Task()
    {
        //Required Constructor
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getTask_status() {
        return task_status;
    }

    public void setTask_status(int task_status) {
        this.task_status = task_status;
    }

    public String getTask_giver() {
        return task_giver;
    }

    public void setTask_giver(String task_giver) {
        this.task_giver = task_giver;
    }
}
