package com.stephen.test.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.stephen.test.R;
import com.stephen.test.base.BaseDialog;
import com.stephen.test.imp.IDialogListener;
import com.stephen.test.imp.IDialogListenerConfirmBack;
import com.stephen.test.utils.DensityUtil;


/**
 * Created by Stephen on 2017/5/9 11:32
 * Email: 895745843@qq.com
 */

class AlertDialog extends BaseDialog implements View.OnClickListener {
    private IDialogListener mIDialogListener;
    private IDialogListenerConfirmBack iDialogListenerConfirmBack;
    private TextView textViewDialogTitle;
    private TextView textViewDialogContent;
    private Button buttonDialogCancel;
    private Button buttonDialogConfirm;

    private String mTitle;
    private String mContent;
    private String[] mOperationTexts;

    AlertDialog(Context context, String title, String[] operationTexts, IDialogListener dialogOnClickListener) {
        super(context, 0);
        this.mContext = context;
        this.mTitle = title;
        this.mOperationTexts = operationTexts;
        this.mIDialogListener = dialogOnClickListener;

        setValues();
        setOnListener();
        this.show();
    }


    AlertDialog(Context context, String title, String content, String[] operationTexts, IDialogListenerConfirmBack iDialogListenerConfirmBack) {
        super(context, 0);
        this.mTitle = title;
        this.mContent = content;
        this.mOperationTexts = operationTexts;
        this.iDialogListenerConfirmBack = iDialogListenerConfirmBack;

        setValues();
        setOnListener();
        this.show();
    }

    protected void initView(){
        this.setContentView(R.layout.dialog_alertdialog_layout);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = (int) (DensityUtil.getScreenWidth(mContext) * 0.87);
        getWindow().setAttributes(lp);
        this.setCanceledOnTouchOutside(false);

        textViewDialogTitle = (TextView) findViewById(R.id.textView_dialog_title);
        textViewDialogContent = (TextView) findViewById(R.id.textView_dialog_content);
        buttonDialogCancel = (Button) findViewById(R.id.button_dialog_cancel);
        buttonDialogConfirm = (Button) findViewById(R.id.button_dialog_confirm);
    }

    private void setValues() {
        if (!TextUtils.isEmpty(mTitle)) {
            textViewDialogTitle.setText(mTitle);
        }
        if (!TextUtils.isEmpty(mContent)) {
            textViewDialogContent.setText(mContent);
        }
        if (mOperationTexts != null && mOperationTexts.length >= 2) {
            buttonDialogCancel.setText(mOperationTexts[0]);
            buttonDialogConfirm.setText(mOperationTexts[1]);
        }
    }

    private void setOnListener() {
        buttonDialogCancel.setOnClickListener(this);
        buttonDialogConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_dialog_cancel) {
            this.dismiss();
            if (mIDialogListener != null) {
                mIDialogListener.click(v, 0);
            }
        } else if (v.getId() == R.id.button_dialog_confirm){
            this.dismiss();
            if (iDialogListenerConfirmBack != null) {
                iDialogListenerConfirmBack.clickRight();
                return;
            }
            if (mIDialogListener != null) {
                mIDialogListener.click(v,1);
            }
        }
    }
}