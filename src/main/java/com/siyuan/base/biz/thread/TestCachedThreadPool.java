package com.siyuan.base.biz.thread;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestCachedThreadPool {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\思远\\Desktop\\面试整理.txt");
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        Semaphore semaphore = new Semaphore(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        final long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            final int num = i;
            Runnable task = () -> {
                try {
                    semaphore.acquire();
                    writer.write(String.valueOf(num) + "\n");
                    semaphore.release();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            cachedThreadPool.submit(task);
        }
        cachedThreadPool.shutdown();
        cachedThreadPool.awaitTermination(1, TimeUnit.HOURS);
        writer.write("---END---\n");
        writer.close();
        System.out.println("应该是要表达些什么");
        final long end = System.currentTimeMillis();
        System.out.println((end - start));
    }
}
