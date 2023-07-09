package com.example.order.test.waitnotify;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestConsumer implements Runnable {

    private Product product;
    private ReentrantLock reentrantLock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public TestConsumer(Product product, ReentrantLock reentrantLock, Condition producerCondition, Condition consumerCondition) {
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
                while (product.getNum() == 0) {
                    // 生产者没有数据,阻塞等待
                    System.out.println("-----进入阻塞(消费者)");
                    product.wait();
                    System.out.println("-----被唤醒(消费者)");
                }
                System.out.println("-----消费者工作");
                product.use();
                System.out.println("-----消费者完成工作");
                // 唤醒生产者可以添加生产了
                product.notify();
            }
        } while (true);
    }

    public void test2() {
        do {
            reentrantLock.lock();
            try {
                while (product.getNum() == 0) {
                    // 生产者没有数据,阻塞等待
                    System.out.println("-----进入阻塞(消费者)");
                    consumerCondition.await();
                    System.out.println("-----被唤醒(消费者)");
                }
                System.out.println("-----消费者工作");
                product.use();
                System.out.println("-----消费者完成工作");
                // 唤醒生产者可以添加生产了
                producerCondition.signal();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        } while (true);
    }
}
