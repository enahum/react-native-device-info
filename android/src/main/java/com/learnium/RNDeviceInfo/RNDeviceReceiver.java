package com.learnium.RNDeviceInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class RNDeviceReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (action.equals("com.android.vending.INSTALL_REFERRER")) {
      SharedPreferences sharedPref = context.getSharedPreferences("react-native-device-info", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();
      editor.putString("installReferrer", intent.getStringExtra("referrer"));
      editor.commit();
    } else if (action.equals("android.intent.action.TIMEZONE_CHANGED")) {
      SharedPreferences sharedPref = context.getSharedPreferences("DEVICE_INFO_PREFERENCES", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();
      editor.putString("timezone", intent.getStringExtra("time-zone"));
      editor.commit();
    }
  }
}
