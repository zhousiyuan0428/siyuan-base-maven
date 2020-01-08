package com.siyuan.base.biz.thread;

import java.util.concurrent.*;

public class SelfDefinedThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 6; i++) {
            final int nums = i;
            Callable<String> callable = () -> {
                System.out.println("我是业务代码逻辑"+nums);
                return "我是业务逻辑返回值"+nums;
            };
            Future<String> submit = poolExecutor.submit(callable);
            try {
                System.out.println(submit.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        poolExecutor.shutdown();
    }
}