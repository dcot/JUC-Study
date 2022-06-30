package com.clf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 */
public class RunnableThreadTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程和任务一起创建");
        });
        t1.setName("t1");

        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName() + "单独创建任务");
        };
        Thread t2 = new Thread(r1, "t2");
        t1.start();
        t2.start();

    }
}
