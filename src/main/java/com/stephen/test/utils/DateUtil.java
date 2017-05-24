package com.stephen.test.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stephen on 2017/5/15 17:04
 * Email: 895745843@qq.com
 */

public class DateUtil {
    public static String date2LongBySecond(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date toDate;
        try {
            toDate = simpleDateFormat.parse(date);
            return toDate.getTime() + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String date2LongByDay(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDate;
        try {
            toDate = simpleDateFormat.parse(date);
            return toDate.getTime() + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static long rq2Long(String rq, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date toDate;
        try {
            toDate = simpleDateFormat.parse(rq);
            return toDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static String date2rq(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateStr;
        dateStr = simpleDateFormat.format(date);
        return dateStr;

    }

    public static Date long2date(long lo, String pattern) {
        return new Date(lo);
    }

    public static String rq2rq(String rqSrc, String pattern0, String pattern1) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern0);
        Date toDate;
        try {
            toDate = simpleDateFormat.parse(rqSrc);
            return date2rq(toDate, pattern1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将时间戳转为代表"距现在多久之前"的字符串
     * @param timeStr   时间戳
     * @return
     */
    public static String getStandardDate(String timeStr) {
        if(timeStr == null || timeStr.length() == 0){
            return "刚刚";
        }
        StringBuffer sb = new StringBuffer();
        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t/**1000*/);
        long mill = (long) Math.ceil(time /1000);//秒前
        long minute = (long) Math.ceil(time/60/1000.0f);// 分钟前
        long hour = (long) Math.ceil(time/60/60/1000.0f);// 小时
        long day = (long) Math.ceil(time/60/60/1000.0f)/24;// 天前
        long month = day/30;// 月前 按30天算的
        long year = day/365;// 年前 按365天算的
        if(year > 0 && day >= 365){
            sb.append(year + "年");
        }else if (month > 0) {
            sb.append(month + "月");
        }else if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    public static String date2LongByminute(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date toDate;
        try {
            toDate = simpleDateFormat.parse(date);
            return toDate.getTime() + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 将年月日按 今天 明天 周几 格式转换
     * @param strDate
     * @return
     */
    public static String getCustomDateFormat(String strDate) {
        if (strDate == null) {
            return "";
        }
        if (strDate.length() >= 10) {
            String s = DateUtil.date2rq(new Date(), "yyyy-MM-dd");
            long systemMills = DateUtil.rq2Long(s, "yyyy-MM-dd");
            long activityMills = DateUtil.rq2Long(strDate, "yyyy-MM-dd");
            String str = (activityMills == systemMills) ? "今天" : ((activityMills - systemMills) / 86400000 == 1) ? "明天" : DateUtil.getCustomWeekFormat(strDate);
            if (str.contains("星期")) {
                str = TextUtils.replace(str, new String[]{"星期"}, new String[]{"周"}).toString();
            }
            return str;
        } else {
            return strDate;
        }
    }

    /**
     * 将年月日 转换成 月日星期几
     * @param date
     * @return
     */
    public static String getCustomWeekFormat(String date){
        return DateUtil.rq2rq(date, "yyyy-MM-dd", "MM-dd EEEE");
    }
    /**
     * 将年月日 转换成 月日星期几 时分
     * @param date
     * @return
     */
    public static String getCustomDateYMWHMFormat(String date){
        return DateUtil.rq2rq(date, "yyyy-MM-dd hh:mm", "MM-dd EEEE hh:mm");
    }

    /**
     * 将时间 与本地时间相差 转为小时
     * @param timeStr   时间戳
     * @return
     */
    public static long getStandard2hours(long timeStr) {
        long time = System.currentTimeMillis() - timeStr;
        return (long) (Math.abs(time)/ 60/ 60 / 1000.0f);// 小时;
    }
}
