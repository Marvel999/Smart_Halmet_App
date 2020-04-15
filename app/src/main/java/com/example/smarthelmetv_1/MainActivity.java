package com.example.smarthelmetv_1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private static int SPLASH_SCREEN_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

      TextView textsmart=(TextView) findViewById(R.id.textsmart);
        TextView texthelmet=(TextView) findViewById(R.id.textHelmet);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.anim1);

        textsmart.startAnimation(animation);
        texthelmet.startAnimation(animation1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,
                        first_activity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);


    }
}
