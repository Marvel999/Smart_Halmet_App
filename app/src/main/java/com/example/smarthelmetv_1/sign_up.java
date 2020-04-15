package com.example.smarthelmetv_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sign_up extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;
    EditText conpassword;
    Button sing;
    String name_1;

    public void Up(View view){
        Drawable d = getResources().getDrawable(R.drawable.circuler_cornner);
        sing.setBackground(d);



        if(name_1==null)
            Log.e( "email: ",""+(name_1==null) );

        else

            Log.e( "email else: ",""+name_1 );



        //sing.setTextColor(Integer.parseInt("#0000"));

        Intent i=new Intent(sign_up.this,
                SING_IN.class);
        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.

        finish();
        //the current activity will get finished.


    }


    /*private void email(View view){
        email.setSelection(4);




    }

    private void name(View view){
        name.setSelection(4);



    }

    private void password(View view){



    }

    private void conpassword(View view){



    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        conpassword=(EditText)findViewById(R.id.conpassword);
        sing=(Button) findViewById(R.id.SignUp);


        //email.setSelection(email.getText().length()/2);
        //name.setSelection(2);
        name_1=email.getText().toString();




    }
}
