package com.example.liuche.timebot;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Setting extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener{

    TextView txvStartTime;
    TextView txvEndTime;
    EditText txtName;
    Button btnConfirm;
    Calendar calendar = Calendar.getInstance();

    //default time is 0:0, if the user does not select a time. This is done so that creating the object
    //Task will not cause Exceptions.
    int startHour = 0;
    int startMinute = 0;
    int endHour = 0;
    int endMinute = 0;

    //create new Task every time the user sets a new Task in Setting activity
    Task task = new Task();

    //flag for distinguish which button is clicked.
    boolean flag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        txvStartTime = findViewById(R.id.txvStartTime);
        txvEndTime = findViewById(R.id.txvEndTime);
        btnConfirm = findViewById(R.id.confirm);
        txtName = findViewById(R.id.txtName);

        txvStartTime.setOnClickListener(this);
        txvEndTime.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }



    @Override
    //determine which button is clicked and act accordingly.
    public void onClick(View view) {

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        if (view == txvStartTime){
            //init new alert message
            TimePickerDialog tpd = new TimePickerDialog(this,this,hour,minute,true);
            tpd.show();
            flag = true;
        }else if (view == txvEndTime){
            //init new alert message
            TimePickerDialog tpd = new TimePickerDialog(this,this,hour,minute,true);
            tpd.show();
            flag = false;
        }else{  //when confirm button is pressed, set the parameters of the Task.


            task.setTask(txtName.getText().toString(),startHour,startHour,endHour,endMinute);
            addTaskToArrList(task);

//            //prints:
            Log.v("Setting",task.name() + " " + task.getStartHour() + " : " + task.getStartMinute() + "\n" + task.getEndHour() + "：" + task.getEndMinute());
            //show Task with Toast.
            Toast tos = Toast.makeText(this,"添加成功：" + task.name() + " " + task.getStartHour() + " : " + task.getStartMinute() + ", " + task.getEndHour() + "：" + task.getEndMinute(), Toast.LENGTH_LONG);
            tos.setGravity(Gravity.TOP,0,75);
            tos.show();

            //kill activity
            finish();
        }


    }


    @Override
    //set txv and set start and end time.
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        if(flag == true){
            startHour = i;
            startMinute = i1;
            txvStartTime.setText("开始时间：" + i + "：" + i1);
        }
        else{
            endHour = i;
            endMinute = i1;
            txvEndTime.setText("结束时间：" + i + "：" + i1);
        }
    }


    //add task to arraylist if there is no conflicts, reject the addition otherwise.
    public boolean addTaskToArrList(Task newTask){

        //avoid comparing Task to null when the arraylist is empty.
        //use binary tree to find correct location, then determine if there are conflicts
        if(ToDoList.taskArrList.size() > 0){

            //traverse through every Tasks in the arraylist.
            //if the task conflicts with newTask, reject request,
            //else add to that index.
            for (Task curTask : ToDoList.taskArrList){
                if (findConflict(newTask,curTask)){
                    return false;
                }
                else {
                    ToDoList.taskArrList.add(ToDoList.taskArrList.indexOf(curTask) , newTask);
                    return true;
                }
            }
            return true;
        }
        else{
            ToDoList.taskArrList.add(newTask);
            return true;
        }
    }



    public boolean findConflict(Task t1, Task t2){

        return true;
    }


}
