package com.clf;

public class TwoPhaseInterrupt {
    public static Thread t1;
    public static void main(String[] args) {
        t1 = new Thread(()->{
           while (true) {
               Thread current = Thread.currentThread();
               Boolean isInterrupted = current.isInterrupted();
               if (current.isInterrupted()) {
                   System.out.println("线程结束回收");
                   break;
               }
               else {
                   System.out.println("监控中");
               }
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   //sleep状态中被打断会进入异常，随后清除打断标记，因此要重新设置,其余状态不会
                   Thread.currentThread().interrupt();
                   e.printStackTrace();
               }
           }
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }
    public static void stop(){
        t1.interrupt();
    }
}
