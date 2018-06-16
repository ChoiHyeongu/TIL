package com.example.choi.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static final String MY_ACTION = "com.example.mybroadcastreceiver.ACTION_MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "전원 연결 됨", Toast.LENGTH_SHORT).show();
        } else if (MY_ACTION.equals(intent.getAction())){
            Toast.makeText(context, "나만의 방송", Toast.LENGTH_SHORT).show();

            abortBroadcast();
        }
    }
}
