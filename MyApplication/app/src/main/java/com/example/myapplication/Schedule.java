package com.example.myapplication;

public class Schedule {

    private int schedule_id;
    private String schedule;
    private String schedule_teacher;
    private int schedule_status;

    public Schedule()
    {
        //Required Constructor
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule_teacher() {
        return schedule_teacher;
    }

    public void setSchedule_teacher(String schedule_teacher) {
        this.schedule_teacher = schedule_teacher;
    }

    public int getSchedule_status()
    {
        return schedule_status;
    }

    public void setSchedule_status(int schedule_status)
    {
        this.schedule_status = schedule_status;
    }
}
