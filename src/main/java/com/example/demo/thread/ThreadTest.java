package com.example.demo.thread;

import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("main-start...");
        MyThread t = new MyThread();
        t.start(); // 启动新线程t1
        Thread t2 = new Thread(new MyRunnable());
        t2.start(); // 启动新线程t2
        System.out.println("main-end...");
    }
}

/**
 * 继承 Thread 方式
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("by Thread start new thread!");
    }
}

/**
 * 实现Runnable接口方式
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("by Runnable start new thread!");
    }
}
