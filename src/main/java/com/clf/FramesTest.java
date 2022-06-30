package com.clf;

public class FramesTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           method1(2);
        });
        t1.setName("t1");
        t1.start();
        method1(1);
    }
    public static void method1(int x) {
        int y = x + 1;
        Object n = method2();
        System.out.println(n);
    }
    public static Object method2() {
        Object n = new Object();
        return n;
    }
}
