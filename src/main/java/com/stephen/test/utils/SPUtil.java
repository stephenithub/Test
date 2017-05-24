package com.stephen.test.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.stephen.test.Test;


/**
 * Created by Stephen on 2017/5/12 15:23
 * Email: 895745843@qq.com
 */

public class SPUtil {
    public static void write(String key, String value) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().putString(key,value).apply();
    }

    public static void write(String key, boolean value) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static String read(String key) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static boolean readBool(String key) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void remove(String key) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }

    public static void clear(String key) {
        SharedPreferences sp = Test.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }
}
