package com.siyuan.base.biz.thread;

public class ThreadB implements Runnable{

    @Override
    public void run(){
        System.out.println("B");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
