package com.example.smarthelmetv_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_activity extends AppCompatActivity {
    Button singup;
    Button singin;
    private static int SPLASH_SCREEN_TIME_OUT=3500;

    public void Sing(View view){
        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner);

        singup.setBackground(d);


        Intent i=new Intent(first_activity.this,
                sign_up.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.
    }

    public void Log(View view){
        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner);

        singin.setBackground(d);

        Intent i=new Intent(first_activity.this,
                SING_IN.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
         singup=(Button)findViewById(R.id.SignUp);
         singin=(Button)findViewById(R.id.SignIn);


    }
}
