package com.example.liuche.timebot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {


    //kill Setting, return Task task;
    //traverse ArrayList
    //if (conflict()）{
    //
    Intent intent = new Intent();
    //tasks are stored and retracted from an arraylist that can be used by all classes
    public static ArrayList<Task> taskArrList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);




    }

    public void goToSetting(View v){
        intent.setClass(this,Setting.class);
        startActivity(intent);

    }
}
