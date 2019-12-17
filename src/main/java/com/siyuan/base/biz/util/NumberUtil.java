package com.siyuan.base.biz.util;

import java.text.NumberFormat;

public class NumberUtil {

    //保留Double四舍五入至指定位数的方法
    public static String format(Double rawNumber,int Digit) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(Digit);
        return numberFormat.format(rawNumber);
    }
}
