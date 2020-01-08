package com.siyuan.base.biz.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public static String format2(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
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

    /**
     * 获取过去或者未来 任意天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
    public static List<String> getSevenDay(int intervals, Boolean isPast) {
        List<String> resultList = new CopyOnWriteArrayList<>();
        if (isPast) {
            for (int i = intervals; i >= 0 ; i--) {
                resultList.add(getPastDate(i));
            }
        } else {
            for (int i = 0; i < intervals; i++) {
                resultList.add(getFutureDate(i));
            }
        }

        return resultList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static String getFutureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }
}
