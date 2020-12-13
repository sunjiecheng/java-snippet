package com.sjc.java.thread.basic;

/**
 * @author jiecheng
 * @create 2020-11-29 下午8:55
 */
public class CreateThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程" + i);
        }
    }

    public static void main(String[] args) {
        CreateThread createThread = new CreateThread();
        createThread.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("main线程" + i);
        }
    }
}
