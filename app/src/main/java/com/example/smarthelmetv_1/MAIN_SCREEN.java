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

public class MAIN_SCREEN extends AppCompatActivity {

    private TextToSpeech textToSpeech;
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





    String name="";
    int count=0;


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


            Intent i=new Intent(MAIN_SCREEN.this,
                    VOICE_PLACE.class);
            //Intent is used to switch from one activity to another.

            startActivity(i);
            //invoke the SecondActivity.

            finish();
            //the current activity will get finished.


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




    public void Location(View view){

        if(count==0){

            Drawable d = getResources().getDrawable(R.drawable.circuler_blue_cornner);

            location.setBackground(d);
            count=1;
            locationPointer.setVisibility(View.VISIBLE);


        }

        else {
            Drawable d = getResources().getDrawable(R.drawable.circuler_cornner_white);

            location.setBackground(d);
            count=0;
            locationPointer.setVisibility(View.INVISIBLE);

        }


    }




    public void Cardview(View view){
        cardView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);

        //btn = (Button) findViewById(R.id.btn);

        name1= (TextView) findViewById(R.id.name);
        locationPointer=(ImageView) findViewById(R.id.location);
        location=(ImageView) findViewById(R.id.locationbtn);
        ac=(ImageView) findViewById(R.id.ac);
        michanice=(ImageView) findViewById(R.id.findmech);
        patrol=(ImageView) findViewById(R.id.patrol);





        number1 = (TextView) findViewById(R.id.number);
        cardView=(CardView) findViewById(R.id.cardview);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.ENGLISH);


                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final TelephonyManager telephonyManager = (TelephonyManager)getSystemService(
                Context.TELEPHONY_SERVICE);
        PhoneStateListener callStateListener = new PhoneStateListener() {
            public void onCallStateChanged(int state, String incomingNumber){
                if(state==TelephonyManager.CALL_STATE_RINGING){

                    String phoneNumber;
                    //Toast.makeText(getApplicationContext(),"Phone is Ringing : "+incomingNumber,
                    //Toast.LENGTH_LONG).show();
                    name = getContactName(incomingNumber, MAIN_SCREEN.this);
                    Toast.makeText(MAIN_SCREEN.this, name, Toast.LENGTH_SHORT).show();
                    name1.setText(name);
                    number1.setText(incomingNumber);

                    //textnumber.setText(incomingNumber);
                    //int speechStatus=textToSpeech.speak(name+" calling", TextToSpeech.QUEUE_FLUSH, null);
                    count++;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                        //ttsGreater21("Hello Boss "+name+" is calling.");
                        cardView.setVisibility(View.VISIBLE);


                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("count1 value: ",""+count );
                        ttsGreater21("Hello Boss "+name+" is calling.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ttsGreater21(name+" is calling.");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ttsGreater21("Have a niceday.");



                        Log.e("count2 value: ",""+count );

                        //ttsGreater21(name+" is calling.");
                        //ttsGreater21(name+" is calling.");
                    } else {
                        ttsUnder20(name+" is calling.");
                        //ttsUnder20(name+" is calling.");
                        //ttsUnder20(name+" is calling.");


                    }


                    /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        tts.speak(name+"calling",TextToSpeech.QUEUE_FLUSH,null,null);
                    } else {
                        tts.speak(name+" calling", TextToSpeech.QUEUE_FLUSH, null);
                    }*/

                    /*tts.speak(name+" calling", TextToSpeech.QUEUE_FLUSH, null);
                    tts.speak(name+" calling", TextToSpeech.QUEUE_FLUSH, null);
                    tts.speak(name+" calling", TextToSpeech.QUEUE_FLUSH, null);*/




                }
                if(state==TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(getApplicationContext(),"Phone in a call or call picked",
                            Toast.LENGTH_LONG).show();
                    textToSpeech.stop();
                    textToSpeech.shutdown();
                }
                if(state==TelephonyManager.CALL_STATE_IDLE){
                    //phone is neither ringing nor in a call

                }
            }
        };
        telephonyManager.listen(callStateListener,PhoneStateListener.LISTEN_CALL_STATE);

        /*btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String data = editText.getText().toString();
                Log.i("TTS", "button clicked: " + data);
                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                if (speechStatus == TextToSpeech.ERROR) {
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
            }

        });*/
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        Log.e("ttsUnder20: ",text );
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, map);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        Log.e("ttsUnder21: ",text );
        String utteranceId=this.hashCode() + text;
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);

    }


    public String getContactName(final String phoneNumber, Context context)
    {
        Uri uri=Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI,Uri.encode(phoneNumber));

        String[] projection = new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME};

        String contactName="";

        Cursor cursor=context.getContentResolver().query(uri,projection,null,null,null);

        if (cursor != null) {
            if(cursor.moveToFirst()) {
                contactName=cursor.getString(0);
            }
            cursor.close();
        }

        return contactName;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {

        }
    }



}
