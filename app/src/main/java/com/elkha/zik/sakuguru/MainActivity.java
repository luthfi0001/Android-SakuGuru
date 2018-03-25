package com.elkha.zik.sakuguru;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LoginMenu=new Intent(MainActivity.this,LoginScreen.class);
                startActivity(LoginMenu);
                finish();
            }
        },1000);
    }
}
