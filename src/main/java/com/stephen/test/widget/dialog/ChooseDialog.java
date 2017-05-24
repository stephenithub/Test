package com.stephen.test.widget.dialog;

import android.content.Context;

import com.stephen.test.imp.IDialogListener;
import com.stephen.test.imp.IDialogListenerConfirmBack;


/**
 * Created by Stephen on 2017/5/9 11:29
 * Email: 895745843@qq.com
 */

public class ChooseDialog {

    public ChooseDialog(Context context, String title, String[] operationTexts, IDialogListener iDialogListener) {
        new AlertDialog(context, title, operationTexts, iDialogListener);
    }

    public ChooseDialog(Context context, String title, String content, String[] operationTexts, IDialogListenerConfirmBack iDialogListenerConfirmBack) {
        new AlertDialog(context, title, content, operationTexts, iDialogListenerConfirmBack);
    }
}
