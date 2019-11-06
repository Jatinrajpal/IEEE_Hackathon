package com.jatin.vjm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Random;

public class booked extends AppCompatActivity {
    TextView txtDate,txtTime;
    String pt="",tt="";
    Button selectDate,selectTime,upload;
    private int mYear, mMonth, mDay, mHour, mMinute;
    FirebaseDatabase database;
    DatabaseReference myRef,dref;
    DatabaseReference myRef1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        selectDate=(Button)findViewById(R.id.button6);
        selectTime=(Button)findViewById(R.id.button7);
        upload=(Button)findViewById(R.id.button9);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference();
        myRef1=database.getReference();
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDate();
            }
        });
        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTime();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                String rr = String.valueOf(r.nextInt(1000));
                //  Toast.makeText(createdoc.this, rr, Toast.LENGTH_SHORT).show();
                myRef = (DatabaseReference) database.getReference("id").child(""+rr);
                dref = myRef.child("a");
                dref.setValue("11");

                Toast.makeText(booked.this, "ok", Toast.LENGTH_SHORT).show();

            }
        });



    }
    public void getDate()
    {

        final Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDay=c.get(Calendar.DAY_OF_MONTH);
        txtDate=(TextView)findViewById(R.id.txtDate);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        if(dayOfMonth<=(c.get(Calendar.DAY_OF_MONTH)+7))
                        {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            pt=txtDate.getText().toString();
                        }
                        else
                        {
                            Toast.makeText(booked.this, "Select an appointment between a span of 7 days", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }
    public void getTime()
    {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
    txtTime=(TextView)findViewById(R.id.txtTime);
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txtTime.setText(hourOfDay + ":" + minute);
                        tt=txtTime.getText().toString();
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }


}
