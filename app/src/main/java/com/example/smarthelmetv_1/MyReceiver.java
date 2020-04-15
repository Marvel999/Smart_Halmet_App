package com.example.smarthelmetv_1;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.widget.Toast;


/**
 * Created by Vinod Dirishala on 11/27/2016.
 */
public class MyReceiver extends BroadcastReceiver {

    String phoneNumber;
    String name;



    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Bundle extras=intent.getExtras();
        if(action.equals("android.intent.action.PHONE_STATE")){
            String state=extras.getString(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){

                String incomingnumber=extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                String msg = "";
                //  String person = getCname(context,msg);

                String names = getContactDisplayNameByNumber(incomingnumber,context);

                //  Toast.makeText(context,"Caller Name"+person,Toast.LENGTH_SHORT).show();

                displayToast(context,"phone is ringing"+incomingnumber+ "calling you mr."+names);

                Intent intent1  = new Intent(context,
                        MainActivity.class);
                intent.putExtra("contactname", names);  //<<< put sms text
                context.startActivity(intent);
                //  displayToast(context,"phone is ringing"+person);
                // displayToast(context,"Vinod your  phone is ringing"+contacname);
            }else if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Toast.makeText(context,"phone in idle", Toast.LENGTH_SHORT).show();
            }else if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                Toast.makeText(context,"phone in offhook", Toast.LENGTH_SHORT).show();
            }

        }else if(action.equals("android.provider.Telephony.SMS_RECEIVED")){

            displayToast(context,"SMS Recived");
        }
    }




    private void displayToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }
    public String getCname(Context context, String name)
    {
        ContentResolver cr=context.getContentResolver();
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            System.out.println(" Phone Nuber.................."+phoneNumber);
            //  aa.add(name);
            // aa.add(phoneNumber);

        }
        return name;
    }

    public String getContactDisplayNameByNumber(String number, Context context) {
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        name = "Incoming call from";

        ContentResolver contentResolver = context.getContentResolver();
        Cursor contactLookup = contentResolver.query(uri, null, null, null, null);

        try {
            if (contactLookup != null && contactLookup.getCount() > 0) {
                contactLookup.moveToNext();
                name = contactLookup.getString(contactLookup.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                // this.id =
                // contactLookup.getString(contactLookup.getColumnIndex(ContactsContract.Data.CONTACT_ID));
                // String contactId =
                // contactLookup.getString(contactLookup.getColumnIndex(BaseColumns._ID));
            }else{
                name = "Unknown number";
            }
        } finally {
            if (contactLookup != null) {
                contactLookup.close();
            }
        }

        return name;
    }


}
