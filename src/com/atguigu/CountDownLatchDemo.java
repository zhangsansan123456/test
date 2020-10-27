package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws  Exception{
        CountDownLatch cd = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开");
                cd.countDown();
            },String.valueOf(i)).start();
        }
        cd.await();
        System.out.println("锁门");
    }
}
