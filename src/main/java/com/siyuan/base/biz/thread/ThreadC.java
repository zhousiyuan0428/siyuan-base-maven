package com.siyuan.base.biz.thread;

public class ThreadC implements Runnable{

    @Override
    public void run(){
        System.out.println("C");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
