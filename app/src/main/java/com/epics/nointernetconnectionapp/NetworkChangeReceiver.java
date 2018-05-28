package com.epics.nointernetconnectionapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by kartikmittal on 5/11/18.
 */

public class NetworkChangeReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        int status = NetworkUtil.getConnectivityStatusString(context);
        System.out.println(intent.getAction());
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {

            if(status==NetworkUtil.NETWORK_STATUS_NOT_CONNECTED){
                Intent i = new Intent(context, Error.class);
                context.startActivity(i);
            }else{
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("i am online"));
                
            }

        }
    }

}