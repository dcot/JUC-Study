package com.clf;

public class ThreadState {
    //线程睡完后未必会立刻执行
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }
}
