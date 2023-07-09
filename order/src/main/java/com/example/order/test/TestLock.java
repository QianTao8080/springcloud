package com.example.order.test;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1  start");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t1  end");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            while (lock.isLocked()) {

            }
            System.out.println("t2 end");
        });
        t2.start();
        t1.start();
    }
}
