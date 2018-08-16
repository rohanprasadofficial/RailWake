package com.example.logarithm.railwake;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    static final String  API_KEY = "y5jg5qw00g";
    JSONDownloader task;
    String  json=null;
    CardView pnrCardView;


    void pnrStatus(View view){
        startActivity(new Intent(getApplicationContext(),PnrStatus.class));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            task = new JSONDownloader();
            //json = task.execute("https://api.railwayapi.com/v2/name-number/train/22640/apikey/"+API_KEY+"/\n" +
            //       "\n").get();

        pnrCardView=findViewById(R.id.pnrCardView);
        pnrCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pnrStatus(v);
            }
        });






    }
}
