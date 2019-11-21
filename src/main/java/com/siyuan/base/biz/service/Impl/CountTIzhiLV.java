package com.siyuan.base.biz.service.Impl;

public class CountTIzhiLV {
    public static void main(String[] args) {
        System.out.println(tizhilv(93,160));
    }

    private static double tizhilv(double yaowei,double tizhong) {
        double c = yaowei*0.74;
        double g = tizhong*0.082+34.89;
        double zhifang = c-g;
        System.out.println("您的脂肪是："+zhifang+"kg");
        return (c-g)/tizhong;
    }
}
