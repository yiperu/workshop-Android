package com.example.HelloWord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by yiperu on 8/5/14.
 */
public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String cadena = getIntent().getStringExtra("variable01");
        Log.d("Henry AT - 2da Actividad", cadena);
    }
}
