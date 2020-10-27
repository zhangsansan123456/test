package com.atguigu;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            for (int i = 1; i <=9 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()
                            +"业务员处理任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
