package com.example.ccproject.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.ccproject.R;


public class SplashScreen extends Activity implements Runnable {
    private TextView inicioSplash;
    private TextView subSplash;
    private static final int DELAY_MILLIS = 5000;







    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        inicioSplash = (TextView) findViewById(R.id.inicioSplash);
        subSplash = (TextView) findViewById(R.id.subSplash);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        inicioSplash.startAnimation(myanim);
        subSplash.startAnimation(myanim);








        Handler handle = new Handler();
        handle.postDelayed(this, DELAY_MILLIS);
    }

    private void changeToMenuActivity() {
        Intent intent = new Intent(SplashScreen.this, Menu.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void run() {
        changeToMenuActivity();
    }


}