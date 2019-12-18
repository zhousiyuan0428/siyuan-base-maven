package com.siyuan.base.biz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    /**
     * 比较两个时间相差小时
     */
    public static double calculatetimeGapHour(Date date1, Date date2) {
        double hour = 0;
        double millisecond = date2.getTime() - date1.getTime();
        hour = millisecond / (60 * 60 * 1000);
        return hour;
    }


    /**
     * 比较两个时间相差分钟
     */
    public static double calculatetimeGapMinute(Date date1, Date date2) {
        double minute = 0;
        double millisecond = date2.getTime() - date1.getTime();
        minute = millisecond / (60 * 1000);
        return minute;
    }

    public static String format(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static Date turnToDate(String date) {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
