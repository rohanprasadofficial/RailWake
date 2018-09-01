package com.example.logarithm.railwake;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME = 4000; //This is 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent mySuperIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mySuperIntent);

                finish();
            }
        }, SPLASH_TIME);
    }
}
