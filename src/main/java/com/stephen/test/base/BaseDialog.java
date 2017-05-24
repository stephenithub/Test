package com.stephen.test.base;

import android.app.Dialog;
import android.content.Context;

import com.stephen.test.R;


/**
 * Created by Stephen on 2017/5/9 11:33
 * Email: 895745843@qq.com
 */

public class BaseDialog extends Dialog {
    protected Context mContext;

    public BaseDialog(Context context) {
        this(context, R.style.AlertDialog);
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
        initView();
    }

    protected void initView(){

    }
}
