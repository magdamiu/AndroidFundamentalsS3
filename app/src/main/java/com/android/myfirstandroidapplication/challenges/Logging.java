package com.android.myfirstandroidapplication.challenges;

import android.util.Log;

import com.android.myfirstandroidapplication.BuildConfig;

// class used in order to log messages in the Logcat window, only in Debug mode
public class Logging {
  public static void show(Object obj, String message) {
      if (BuildConfig.DEBUG) {
          Log.e(obj.getClass().getName(), message);
      }
  }
}