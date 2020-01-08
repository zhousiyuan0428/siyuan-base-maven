package com.siyuan.base.biz.thread;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    final CountDownLatch latch = new CountDownLatch(11);

    Thread thread = new Thread(() -> {
        System.out.println("线程1" + Thread.currentThread().getId() + "额外的订单");
        latch.countDown();
    });

    public void test() {
        thread.start();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println("线程" + Thread.currentThread().getId() + "额外的订单"+ "..........start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getId() + "额外的订单"+ "..........end");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我必须卡在最后执行的逻辑："+latch.getCount());
    }

    public static void main(String[] args) {
        new TestCountDownLatch().test();
    }

}
