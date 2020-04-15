package com.example.smarthelmetv_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SING_IN extends AppCompatActivity {
    Button in;
    EditText gmail;
    EditText pass;

    String email="manishjobs1999@gmail.com";
    String password="manish";




    public void log(View view){

        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner);
        in.setBackground(d);
        //sing.setTextColor(Integer.parseInt("#0000"));

        Intent i=new Intent(SING_IN.this,
                MAIN_SCREEN.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing__in);
        in=(Button)findViewById(R.id.SignUp);
        gmail=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);








    }
}
