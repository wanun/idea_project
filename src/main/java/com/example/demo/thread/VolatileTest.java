package com.example.demo.thread;

public class VolatileTest {

    /**
     * 有volatile和没有的区别
     */
    //private static  boolean flag = true;
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        Thread.sleep(1000); //暂停1秒 保证线程1 启动并运行。
        new Thread2().start();
    }

    /**
     * 线程1 一个循环，如果 flag为false 跳出循环
     */
    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (flag) {

            }
            System.out.println("thread1-run");
        }
    }

    /**
     * 线程2  2秒后将flag改成false
     */
    static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2-run");
            flag = false;
            System.out.println("flag 被改成false");
        }
    }
}
