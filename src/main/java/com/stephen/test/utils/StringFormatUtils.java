package com.stephen.test.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by Stephen on 2017/5/18 13:51
 * Email: 895745843@qq.com
 */

public class StringFormatUtils {
    public static String convert2double(double d){
        return new DecimalFormat("######0.00").format(d);
    }

    public static String convert2double(String s){
        double d;
        try {
            d = Double.parseDouble(s);
            return String.format(Locale.getDefault(),"¥ %.2f", d);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "¥ 0.00";
    }

    public static String formatAccountNumber(String account){
        String blur = "******";
        if (TextUtils.isEmpty(account) || account.length() <= 7) {
            return blur;
        }
        String prefixStr = account.substring(0, 3);
        String suffixStr = account.substring(account.length() - 4);
        return prefixStr + "******" + suffixStr;
    }

    public static String formatMoney(String s){
        String s1 = convert2double(s);
        return String.format(s1, "¥ %s");
    }

    public static String formatMoney(double s){
        String s1 = convert2double(s);
        return String.format(s1, "¥ %s");
    }
}
