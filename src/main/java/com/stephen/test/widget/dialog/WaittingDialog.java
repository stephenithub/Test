package com.stephen.test.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.stephen.test.R;
import com.stephen.test.utils.DPUtil;


/**
 * Created by Stephen on 2017/5/9 9:53
 * Email: 895745843@qq.com
 */

public class WaittingDialog extends Dialog {
    private static int imgResourceID = R.mipmap.icon_loadding_default;
    private static WaittingDialog mWaittingDialog;
    private ImageView imageView;
    private RotateAnimation mRotateAnimation;

    public static WaittingDialog newInstance(Context context){
        return newInstance(context, R.style.WaittingDialog);
    }

    public static WaittingDialog newInstance(Context context, int theme){
        if (mWaittingDialog == null) {
            mWaittingDialog = new WaittingDialog(context, theme);
        }
        return mWaittingDialog;
    }

    private WaittingDialog(Context context) {
        this(context, R.style.WaittingDialog);
    }

    private WaittingDialog(Context context, int theme) {
        super(context, theme);
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(imgResourceID);
        FrameLayout.LayoutParams fLayoutParams = new FrameLayout.LayoutParams(DPUtil.dip2px(context, 60), DPUtil.dip2px(context, 60));
        this.setContentView(imageView, fLayoutParams);
        this.getWindow().getAttributes().gravity = Gravity.CENTER;
        this.setCanceledOnTouchOutside(false);
        mWaittingDialog = this;
        init();
    }

    private void init() {
        mRotateAnimation = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(1000L);
        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setRepeatCount(-1);
        mRotateAnimation.setRepeatMode(Animation.RESTART);
    }

    @Override
    public void show() {
        clearAnimations();
        super.show();
        imageView.startAnimation(mRotateAnimation);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        clearAnimations();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {
            dismiss();
        }
    }

    private void clearAnimations() {
        imageView.clearAnimation();
    }

    public void reset() {
        mWaittingDialog = null;
    }
}
