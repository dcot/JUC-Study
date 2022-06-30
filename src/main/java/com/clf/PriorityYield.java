package com.clf;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PriorityYield {
    private static Object lock = new Object();
    private static int cnt1 = 0;
    private static int cnt2 = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                while (true) {
                    Thread.yield();
                    cnt1++;
                }
            }
        };

        Thread t2 = new Thread("t1") {
            @Override
            public void run() {
                while (true) {
                    cnt2++;
                }
            }
        };
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        Thread.sleep(100L);
        t1.stop();
        t2.stop();
        Thread.sleep(100L);
        System.out.println(cnt1+" "+t1.getState());
        System.out.println(cnt2+" "+t2.getState());
    }
}
