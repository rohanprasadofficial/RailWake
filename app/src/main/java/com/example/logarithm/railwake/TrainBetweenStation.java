package com.example.logarithm.railwake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import static com.example.logarithm.railwake.MainActivity.API_KEY;



public class TrainBetweenStation extends AppCompatActivity {

    JSONDownloader task;
    String listofStations;
    AutoCompleteTextView sourceStation,destinationStation;
    ArrayAdapter<String> adapter;
    private static final String[]  Stations={"Hello"};
    @Override





    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_between_station);
        task=new JSONDownloader();
        sourceStation =  findViewById(R.id.sourceStation);
        destinationStation=findViewById(R.id.DestinationStation);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Stations);
        sourceStation.setAdapter(adapter);
        sourceStation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("before text chnaged",s.toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("afert text changed",s.toString());
                try {
                    listofStations =task.execute("https://api.railwayapi.com/v2/suggest-station/name/"+s.toString()+"/apikey/y5jg5qw00g/").get();
                    Log.i("Stations",listofStations);

                    Log.i("Ontext changed",s.toString());

                }catch (Exception e){
                    Toast.makeText(TrainBetweenStation.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });




    }
}
