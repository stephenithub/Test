package com.stephen.test.utils;

import android.util.Log;


/**
 * Created by Stephen on 04/12/2017.
 * Emial: 895745843@qq.com
 */

public class LogUtil {
    private static final boolean DEV_MODE = false;
    private static final int LOG_MAXLENGTH  = 2000;
    private static final String TAG = LogUtil.class.getSimpleName();

    public static void E(String msg){
        LogUtil.E(LogUtil.class.getSimpleName(), msg);
    }

    public static void E(String tag, String msg) {
        if (DEV_MODE) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.e(TAG, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e(tag, msg.substring(start, strLength));
                    break;
                }
            }
        }
    }
}
