package com.siyuan.base.util;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadPollUtil {

    /**
     * @param paramList 任务参数列表
     * @param process   要执行的功能
     * @param threadNum 线程数
     * @param <P>       参数类型
     * @param <V>       返回值类型
     * @return 返回结果集
     * @throws InterruptedException
     */
    public static <P, V> Map<Integer, V> process(final List<P> paramList, final Process<P, V> process, int threadNum){
        //如果任务数少于线程数取任务为线程个数
        threadNum = Math.min(paramList.size(), threadNum);
        //保证任务是顺序执行的
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        //用于统计已经执行完成的线程
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        //保存任务执行结果
        final ConcurrentHashMap<Integer, V> resultMap = new ConcurrentHashMap<>();
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadNum);
        threadPool.setMaximumPoolSize(threadNum);
        for (int i = 0; i < threadNum; i++) {
            threadPool.execute(() -> {
                try {
                    while (true) {
                        int index = atomicInteger.getAndAdd(1);
                        if (index >= paramList.size()) {
                            break;
                        }
                        P param = paramList.get(index);
                        try {
                            System.out.println("index:{}" + index);
                            V result = process.doTask(param);
                            if (result != null) {
                                log.info("index:{} result:{}", index, result.toString());
                                resultMap.put(index, result);
                            }
                        } catch (Exception e) {
                            log.error("运行失败 param:{}", param.toString(), e);
                        }
                    }
                } catch (Exception e) {
                    log.error(null, e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
            log.error(null, e);
        }
        threadPool.shutdown();
        return resultMap;
    }

    /**
     * @param <P> 参数类型
     * @param <V> 返回值类型
     */
    public interface Process<P, V> {
        V doTask(P p);
    }
}
