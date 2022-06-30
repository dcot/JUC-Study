package com.clf;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "JoinDemo")
public class JoinDemo {
    private static int cnt1 = 0;
    private static int cnt2 = 0;

    //join的本质是调用wait方法，wait方法是阻塞当前线程，而不是t1，Main线程调用，因此Main线程需要等待t1结束后再被唤醒
    //t1结束时会自动调用notifyAll
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cnt1 = 10;
            }
        };

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cnt2 = 20;
            }
        };
        t1.start();
        t2.start();
        log.debug("join begin");
        t1.join();
        log.debug("t1 join end");
        t2.join();
        log.debug("t2 join end");
        log.debug("cnt1: {} , cnt2: {}", cnt1, cnt2);
        TimeUnit.SECONDS.sleep(1);
    }
}
