package com.jagriti.multithreading.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PrintInOrder {

    public PrintInOrder() {

        Executors.newSingleThreadExecutor();
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.wait();
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
