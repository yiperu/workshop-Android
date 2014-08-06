package com.example.HelloWord;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
//public class MainActivity extends ActionBarActivity {
    /**
     * Called when the activity is first created.
     */
    private HelloBroadcastReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        Intent i = new Intent(this, SecondActivity.class);
//        i.putExtra("variable01", "Dato de la Variable 01");
//
//        startActivity(i);
//        access();
        Button btnLinear = (Button)findViewById(R.id.idBtnLinearLayout);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LinearActivity.class);
                startActivity(i);

            }
        });


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

    @Override
    protected void onResume() {
        // Se registra el broadcast
        this.mReceiver = new HelloBroadcastReceiver();
        registerReceiver(this.mReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        super.onResume();
        Log.d("Hello Word", "Estas pasando por onResume");
    }

    @Override
    protected void onPause() {
        // Se des-registra el broadcast
        unregisterReceiver(mReceiver);
        super.onPause();
        Log.d("Hello Word","onPause");
    }
}
