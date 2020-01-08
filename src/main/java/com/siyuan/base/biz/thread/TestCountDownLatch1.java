package com.siyuan.base.biz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch1 {
    final CountDownLatch latch = new CountDownLatch(2);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    Callable<String> c1 = () -> {
        latch.countDown();
        System.out.println("c1执行完成");
        return "c1执行完成";
    };
    Callable<String> c2 = () -> {
        latch.countDown();
        System.out.println("c2执行完成");
        return "c2执行完成";
    };

    public void test(){
        executor.submit(c1);
        executor.submit(c2);
        executor.shutdown();
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new TestCountDownLatch1().test();
    }

}
