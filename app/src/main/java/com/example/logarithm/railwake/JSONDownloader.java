package com.example.logarithm.railwake;

import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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