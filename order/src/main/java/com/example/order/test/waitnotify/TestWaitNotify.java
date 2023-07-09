package com.example.order.test.waitnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestWaitNotify {
    public static void main(String[] args) {
        Product product = new Product();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition producerCondition = reentrantLock.newCondition();
        Condition consumerCondition = reentrantLock.newCondition();
        Thread t1 = new Thread(new TestProducer(product, reentrantLock, producerCondition, consumerCondition));
        Thread t2 = new Thread(new TestProducer(product, reentrantLock, producerCondition, consumerCondition));
        Thread t3 = new Thread(new TestConsumer(product, reentrantLock, producerCondition, consumerCondition));
        t1.start();
        t2.start();
        t3.start();
    }
}
