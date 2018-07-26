package com.example.liuche.timebot;

//Task has a start time and an end time
//Tasks can be stored in arraylist in chronological order.
public class Task {

    private String name = "";
    private int startHour = 0;
    private int startMinute = 0;
    private int endHour = 0;
    private int endMinute = 0;


    public Task(){

    }

    public Task(String name, int startHour, int startMinute, int endHour, int endMinute){
        this.name = name;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }



    //getters:
    public String name(){
        return name;
    }

    public int getStartHour(){
        return startHour;
    }

    public int getStartMinute(){
        return startMinute;
    }

    public int getEndHour(){
        return endHour;
    }

    public int getEndMinute(){
        return endMinute;
    }

    //setters:
    public void setName(String name){
        this.name = name;
    }

    public void setStartHour(int hour){
        startHour = hour;
    }

    public void setStartMinute(int minute){
        startMinute = minute;
    }

    public void setEndHour(int hour){
        endHour = hour;
    }

    public void setEndMinute(int minute){
        endMinute = minute;
    }

    public void setTask(String name, int startHour, int startMinute, int endHour, int endMinute){
        this.name = name;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }
}
