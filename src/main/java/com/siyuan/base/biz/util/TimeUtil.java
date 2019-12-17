package com.siyuan.base.biz.util;

import java.util.Date;

public class TimeUtil {

    /** 比较两个时间相差小时 */
    public static double calculatetimeGapHour(Date date1, Date date2) {
        double hour = 0;
        double millisecond = date2.getTime() - date1.getTime();
        hour = millisecond / (60 * 60 * 1000);
        return hour;
    }


    /** 比较两个时间相差分钟 */
    public static double calculatetimeGapMinute(Date date1, Date date2) {
        double minute = 0;
        double millisecond = date2.getTime() - date1.getTime();
        minute = millisecond / (60 * 1000);
        return minute;
    }

}
