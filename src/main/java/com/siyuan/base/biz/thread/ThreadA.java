package com.siyuan.base.biz.thread;

public class ThreadA implements Runnable{

    @Override
    public void run(){
        System.out.println("A");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
