package com.stephen.test.widget.toast;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.stephen.test.R;


/**
 * Created by Stephen on 2017/5/17 17:01
 * Email: 895745843@qq.com
 */

public class SimpleToast {

    public static void toastLong(Context context, String content) {
        showToastSafeText(context, content, Toast.LENGTH_LONG);
    }

    public static void toastShort(Context context, String content) {
        showToastSafeText(context, content, Toast.LENGTH_SHORT);
    }


    public static void toastLong(Context context, int resId) {
        showToastSafeText(context, resId, Toast.LENGTH_LONG);
    }

    public static void toastShort(Context context, int resId) {
        showToastSafeText(context, resId, Toast.LENGTH_SHORT);
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafeText(Context context, final int resId, final int showTime) {
        showToastSafeText(context, context.getResources().getString(resId), showTime);
    }

    /**
     * 对toast的简易封装。线程安全，可以在非UI线程调用。
     */
    public static void showToastSafeText(final Context context, final String str, final int showTime) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new android.os.Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                showToastText(context, str, showTime);
            }
        });
    }

    private static void showToastText(Context context, String content, int showTime) {
        if (content != null && context != null) {
            View view = LayoutInflater.from(context).inflate(R.layout.toast_default, null);
            TextView textView = (TextView) view.findViewById(R.id.toast_text);
            textView.setText(content);
            Toast toast = new Toast(context);
            toast.setDuration(showTime);
            toast.setGravity(Gravity.BOTTOM, Gravity.CENTER_HORIZONTAL, 100);
            toast.setView(view);
            toast.show();
        }
    }
}
