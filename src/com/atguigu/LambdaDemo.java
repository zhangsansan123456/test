package com.atguigu;


@FunctionalInterface
interface  Foo{
    public int add(int x,int y);
    default int div(int x,int y) {
        return  x/y;

    }


    public static int sub(int x,int y){
        return x-y;
    }
    public static int sub1(int x,int y){
        return x-y;
    }
}



public class LambdaDemo {
    public static void main(String[] args)throws Exception {

//        Foo foo = new Foo() {
//            @Override
//            public int add(int x, int y) {
//                System.out.println("hello!!");
//                return x+y;
//            }
//        };

        Foo foo = (int x,int y)->{
            System.out.println("hello!!");
            return x+y;
        };

        System.out.println(foo.add(10, 5));
        System.out.println(foo.div(10, 5));
        System.out.println(Foo.sub(10, 5));
        System.out.println(Foo.sub1(8, 5));
    }
}
