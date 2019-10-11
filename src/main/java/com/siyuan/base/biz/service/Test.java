package com.siyuan.base.biz.service;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        String inputStr = null;
        Scanner in = new Scanner(System.in);
        double x = 0;
        boolean b = true;
        System.out.println("请输入数字");
//        try {
//            x = in.nextDouble();
//            b = false;
//        }
//        while(b){
//            try {
//                x = in.nextDouble();
//                b = false;
//            }catch (Exception e){
//                System.out.println("输入有误，请重新输入");
//                in.nextLine();
//            }
//        }
        System.out.println("输入数字为"+x);
        in.close();
    }
}
