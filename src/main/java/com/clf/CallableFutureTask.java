package com.clf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建任务，但从源码上来说真正在线程中执行的任务是futureTask，因为futureTask继承了RunnableFuture，RunnableFuture继承了Runnable
        Callable<Long> callable = ()->{
            Long start = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "future task");
            return System.currentTimeMillis()-start;
        };
        //使用futureTask获取返回值
        FutureTask<Long> futureTask = new FutureTask<>(() -> {
            return 0L;
        });

        Thread t3 = new Thread(futureTask,"t3");
        t3.start();

        System.out.println(Thread.currentThread().getName() + ":" + futureTask.get());
    }
}
