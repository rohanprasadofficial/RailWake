package com.example.logarithm.railwake;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String  API_KEY = "y5jg5qw00g";

    class JSONDownloader extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {
            URL url;
            try {
                HttpURLConnection connection;
                url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream ip = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(ip);
                int data = reader.read();
                String result = "";
                while (data != -1) {
                    char ele = (char) data;
                    result = result + ele;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String  json=null;
        try {
           JSONDownloader task = new JSONDownloader();
           json = task.execute("https://api.railwayapi.com/v2/name-number/train/22640/apikey/"+API_KEY+"/\n" +
                   "\n").get();

        } catch (Exception e) {

            Log.i("The Exception is  ", e.toString());

        }
        Log.i("RESULT",json);



    }
}
