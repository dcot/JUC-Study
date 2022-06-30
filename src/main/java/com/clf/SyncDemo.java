package com.clf;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "SyncDemo")
public class SyncDemo {
    private static Integer num = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                //使用synchronized上锁只能阻塞其余线程，时间片仍然会用完
                synchronized (lock) {
                    num++;
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    num--;
                }
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("num: {}", num);
    }
}
