package com.stephen.test.utils;

import android.content.Context;

/**
 * Created by Stephen on 2017/5/9 10:39
 * Email: 895745843@qq.com
 */

public class DPUtil {
    /**
     * dp2px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
