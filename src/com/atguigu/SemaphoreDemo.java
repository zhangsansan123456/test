package com.atguigu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    sp.acquire();
                    System.out.println(Thread.currentThread().getName()+"号车驶入停车位-------------");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() +"号车离开停车位++++++++++++++");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    sp.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
