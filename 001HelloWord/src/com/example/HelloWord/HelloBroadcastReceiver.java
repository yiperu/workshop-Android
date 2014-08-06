package com.example.HelloWord;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yiperu on 8/6/14.
 */
public class HelloBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadCast Receiver","Power is Conected");
    }
}
