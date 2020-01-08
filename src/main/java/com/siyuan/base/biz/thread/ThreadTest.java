package com.siyuan.base.biz.thread;

import org.springframework.cache.annotation.Cacheable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadTest {

    public static void SemaphoreFunction() {
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    //申请一个许可,许可池令牌数-1,若许可池为0则申请许可失败，阻塞线程
                    semaphore.acquire();
                    System.out.println(num);
                    //模仿耗时操作
                    Thread.sleep(2000);
                    //释放一个许可,许可池令牌数+1
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void testFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Callable<String> callable = () -> {
                System.out.println("逻辑" + num + "正在执行");
                return "逻辑" + num + "执行完成";
            };
            fixedThreadPool.submit(callable);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fixedThreadPool.shutdown();
    }

    public static void main(String[] args) {
        testFixedThreadPool();
    }
}
