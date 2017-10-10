package com.kevinAo.news;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //延时跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //跳转到主界面
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        },2000);
    }
}
