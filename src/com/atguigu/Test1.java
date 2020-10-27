    package com.atguigu;


class ShareDataOne{
    private  int nunmber=0;
    public synchronized void  incre() throws InterruptedException {
        while(nunmber!=0){
            this.wait();
        }
        nunmber++;
        System.out.println(Thread.currentThread().getName()+nunmber);
        this.notifyAll();
    }
    public synchronized void  decre() throws InterruptedException {
        while(nunmber!=1){
            this.wait();
        }
        nunmber--;
        System.out.println(Thread.currentThread().getName()+nunmber);
        this.notifyAll();
    }
    public synchronized void  incre1() throws InterruptedException {
        while(nunmber!=0){
            this.wait();
        }
        nunmber++;
        System.out.println(Thread.currentThread().getName()+nunmber);
        this.notifyAll();
    }
    public synchronized void  decre1() throws InterruptedException {
        while(nunmber!=1){
            this.wait();
        }
        nunmber++;
        System.out.println(Thread.currentThread().getName()+nunmber);
        this.notifyAll();
    }
}
public class Test1 {

    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA:").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB:").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.incre1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"cc:").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.decre1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"dd:").start();

        System.out.println();
    }
}
