package com.example.mydocapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScheduleAppointment extends AppCompatActivity {

    TextView DocName;
    TextView DocAddress;
    TextView DocTime;
    Button ConfirmAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_appoinment);

        setTitle("Schedule the Appointment");

        DocName = findViewById(R.id.DocName);
        DocAddress = findViewById(R.id.DocAddress);
        DocTime = findViewById(R.id.DocTime);
        ConfirmAppointment = findViewById(R.id.ConfirmAppointment);

        String docname = "name not set";
        String docaddress = "name not set";
        String doctime = "name not set";

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            docname = extras.getString("docname");
            docaddress = extras.getString("docaddress");
            doctime = extras.getString("doctime");

        }

        DocName.setText(docname);
        DocAddress.setText(docaddress);
        DocTime.setText(doctime);

        ConfirmAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder thankyou = new AlertDialog.Builder(ScheduleAppointment.this);
                thankyou.setTitle("Thank You for Using MyDocApp!");
                thankyou.setMessage("Please follow CO-VID 19 protocols\n" + "\n" + "Your appointment has been scheduled successfully\n\n" + "Time:- " + DocTime.getText().toString());

                thankyou.create().show();

            }});

    }

}