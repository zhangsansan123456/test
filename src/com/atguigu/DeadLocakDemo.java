package com.atguigu;

import java.util.concurrent.TimeUnit;

public class DeadLocakDemo {

    static Object objectLocakA=new Object();
    static Object objectLocakB=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (objectLocakA){
                System.out.println(Thread.currentThread().getName()+"\t"+"自己持有A锁");
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (objectLocakB){
                    System.out.println(Thread.currentThread().getName()+"\t"+"自己持有B锁");
                }
            }
        },"A").start();
        new Thread(()->{
            synchronized (objectLocakB){
                System.out.println(Thread.currentThread().getName()+"\t"+"自己持有B锁");
                try{
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (objectLocakA){
                    System.out.println(Thread.currentThread().getName()+"\t"+"自己持有A锁");
                }
            }


        },"A").start();
    }
}
