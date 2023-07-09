package com.example.order.test.waitnotify;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class TestProducer implements Runnable {

    private Product product;
    private ReentrantLock reentrantLock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public TestProducer(Product product, ReentrantLock reentrantLock, Condition producerCondition, Condition consumerCondition) {
        this.product = product;
        this.reentrantLock = reentrantLock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    @SneakyThrows
    @Override
    public void run() {
        test2();
    }

    public void test1() throws InterruptedException {
        do {
            synchronized (product) {
                while (product.getNum() == 1) {
                    System.out.println("生产者进入阻塞");
                    product.wait();
                    System.out.println("生产者被唤醒");
                }
                System.out.println("生产者开始工作");
                product.add();
                System.out.println("生产者完成工作");
                // 当生产队列有数据之后通知唤醒消费者
                product.notify();
            }
        } while (true);
    }

    public void test2() {
        do {
            reentrantLock.lock();
            try {
                while (product.getNum() == 1) {
                    System.out.println("生产者进入阻塞");
                    producerCondition.await();
                    System.out.println("生产者被唤醒");
                }
                System.out.println("生产者开始工作");
                product.add();
                System.out.println("生产者完成工作");
                // 当生产队列有数据之后通知唤醒消费者
                consumerCondition.signal();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }

        } while (true);
    }
}
