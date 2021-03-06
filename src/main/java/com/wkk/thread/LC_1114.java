package com.wkk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114 按序打印
 * @author weikunkun
 * @since 2021/3/19
 */
public class LC_1114 {
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);

    public LC_1114() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}
