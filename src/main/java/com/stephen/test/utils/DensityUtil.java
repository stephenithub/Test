package com.stephen.test.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Stephen on 2017/5/9 11:38
 * Email: 895745843@qq.com
 */

public class DensityUtil {
    private static DisplayMetrics displayMetrics;

    public static int getScreenHeight(Context context) {
        if (displayMetrics == null) {
            setDisplayMetrics(context.getResources().getDisplayMetrics());
        }
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        if (displayMetrics == null) {
            setDisplayMetrics(context.getResources().getDisplayMetrics());
        }
        return displayMetrics.widthPixels;
    }

    private static void setDisplayMetrics(DisplayMetrics DisplayMetrics) {
        displayMetrics = DisplayMetrics;
    }
}
