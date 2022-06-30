package com.clf;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    //阻塞状态的线程被打断后会抛出异常，正常运行的线程则由线程内代码自行决定下一步操作
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Long start = System.currentTimeMillis();
            try {
//                Thread.sleep(2000L);
//                System.out.println("working");
                  while (true) {
                      if(Thread.currentThread().isInterrupted()) {
                          System.out.println("Interrupted");
                          System.out.println(Thread.currentThread().getState());
                          break;
                      }
                  }
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getState());
                e.printStackTrace();
            }
        });
        t1.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
