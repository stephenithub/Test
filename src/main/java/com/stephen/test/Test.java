package com.stephen.test;

import android.app.Application;
import android.content.Context;

/**
 * Created by Stephen on 2017/5/24 17:35
 * Email: 895745843@qq.com
 */

public class Test {

    public static Context mContext;

    public static void initialize(Context context) {
        if(context == null) {
            throw new IllegalArgumentException("context can not be null");
        }

        if(!(context instanceof Application)) {
            throw new RuntimeException("context must be an Application Context");
        }
        mContext = context;
    }

    public static Context getContext(){
        return mContext;
    }
}
