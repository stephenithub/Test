package com.stephen.test.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stephen.test.widget.dialog.WaittingDialog;


/**
 * Created by Stephen on 2017/5/8 16:09
 * Email: 895745843@qq.com
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getIntentData();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        WaittingDialog.newInstance(this).reset();
        super.onDestroy();
    }

    public void getIntentData(){

    }
}
