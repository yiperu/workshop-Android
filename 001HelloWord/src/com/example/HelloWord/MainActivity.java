package com.example.HelloWord;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;

public class MainActivity extends Activity {
//public class MainActivity extends ActionBarActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("variable01", "Dato de la Variable 01");
        startActivity(i);

        access();


    }


    public void access() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(Contacts.People.CONTENT_URI, null, null, null, null);
        if(cur.getCount() > 0){
            while (cur.moveToNext()){

                String name = cur.getString(cur.getColumnIndex(Contacts.People.DISPLAY_NAME));
                String id = cur.getString(cur.getColumnIndex(Contacts.People._ID));
            }
        }
    }
}
