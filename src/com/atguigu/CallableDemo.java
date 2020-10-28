package com.atguigu;


import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public   void run(){

    }
}
class MyThread2 implements Callable<Integer>{
    @Override
    public  Integer call()throws  Exception{
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName());
        return  1024;
    }
}
public class CallableDemo {
    public static void main(String[] args)throws Exception {
        FutureTask<Integer> ft = new FutureTask<Integer>(new MyThread2());
        new Thread(ft,"AAA").start();
        FutureTask<Integer> ft1 = new FutureTask<Integer>(new MyThread2());
        new Thread(ft1,"BBB").start();
        System.out.println("ft = " + ft.get());
        System.out.println("ft = " + ft1.get());
        System.out.println(Thread.currentThread().getName());
    }
}
