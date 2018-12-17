package com.example.logarithm.railwake;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class TrainBetweenStation extends AppCompatActivity {

    JSONDownloader task;
    AutoCompleteTextView sourceStation,destinationStation;
    EditText date;
    DatePickerDialog datePickerDialog;
    private int Year,Month,Day;


    public void DateShower(View view)
    {
        Log.i("Day",String.valueOf(Day));
        Log.i("Month",String.valueOf(Month+1));
        Log.i("Year",String.valueOf(Year));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_station);
        task=new JSONDownloader();
        sourceStation =  findViewById(R.id.sourceStation);
        destinationStation=findViewById(R.id.DestinationStation);
        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(TrainBetweenStation.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                Log.i("Date",String.valueOf(dayOfMonth));
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                                Year=year;
                                Month=monthOfYear;
                                Day=dayOfMonth;

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

                }

        });


    }}



