package com.example.nam.kcb_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Kim on 2018-01-31.
 * MainActivity를 띄우기 전 Splash Image를 띄우기 위해 사용
 */

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(4000); //4초 Delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
