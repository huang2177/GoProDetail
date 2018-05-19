package com.module.base.utils;

import android.util.Log;

import com.module.base.BuildConfig;

/**
 * Created by shibing on 18/5/19.
 */

public class Logger {
    public static void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg);
        }
    }
}
