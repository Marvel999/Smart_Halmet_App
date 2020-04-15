package com.example.smarthelmetv_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class VOICE_PLACE extends AppCompatActivity {

    private Button btn;
    private EditText editText;
    private TextView name1;
    CardView cardView;
    private TextView number1;
    ImageView location;
    ImageView patrol;
    ImageView ac;
    ImageView michanice;
    ImageView locationPointer;
    ImageView patroli1;
    ImageView patroli2;





    String name="";
    int count=0;


    public void Patrol1(View view){
        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

        patroli1.setBackground(d);


        Intent i=new Intent(VOICE_PLACE.this,
                tracking.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.


    }


    public void Patrol2(View view){
        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

        patroli2.setBackground(d);


        Intent i=new Intent(VOICE_PLACE.this,
                tracking.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.



    }



    public void Ac(View view){

        if(count==0){

            Drawable d = getResources().getDrawable(R.drawable.circuler_blue_cornner);

            ac.setBackground(d);
            count=1;


        }

        else {
            Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

            ac.setBackground(d);
            count=0;
        }


    }



    public void Patrol(View view){

        if(count==0){

            Drawable d = getResources().getDrawable(R.drawable.circuler_blue_cornner);

            patrol.setBackground(d);
            count=1;


            /*Intent i=new Intent(MAIN_SCREEN.this,
                    VOICE_PLACE.class);
            //Intent is used to switch from one activity to another.

            startActivity(i);
            //invoke the SecondActivity.

            finish();
            //the current activity will get finished.*/


        }

        else {
            Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

            patrol.setBackground(d);
            count=0;
        }


    }

    public void Mech(View view){

        if(count==0){

            Drawable d = getResources().getDrawable(R.drawable.circuler_blue_cornner);

            michanice.setBackground(d);
            count=1;


        }

        else {
            Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

            michanice.setBackground(d);
            count=0;
        }


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice__place);

        ac=(ImageView) findViewById(R.id.ac);
        michanice=(ImageView) findViewById(R.id.findmech);
        patrol=(ImageView) findViewById(R.id.patrol);
        patroli1=(ImageView) findViewById(R.id.patrol1);
        patroli2=(ImageView) findViewById(R.id.patrol2);



    }




}
