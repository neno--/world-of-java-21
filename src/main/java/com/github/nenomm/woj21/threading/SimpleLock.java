package com.github.nenomm.woj21.threading;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLock {

  private static final Logger log = LoggerFactory.getLogger(SimpleLock.class);

  public static void main(String[] args) throws InterruptedException {
    final MyCounter counter = new MyCounter();

    final Runnable runnable = () -> {
      log.info("Starting thread {}", Thread.currentThread().getName());
      try {
        counter.increment();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      log.info("Stopping thread {}", Thread.currentThread().getName());
    };

    Thread[] threads = new Thread[5];
    for (int i = 0; i < 5; i++) {
      threads[i] = new Thread(runnable);
      threads[i].start();
    }

    for (int i = 0; i < 5; i++) {
      log.info("Thread-{} state is {} before", i, threads[i].getState());
      threads[i].join();
      log.info("Thread-{} state is {} after", i, threads[i].getState());
      log.info("Thread-{} joined", i);
    }

    log.info("Execution result: {}", counter);
  }

  public static class MyCounter {

    private int count;
    private final Lock lock;
    final Condition counterIsNot2;

    private MyCounter() {
      count = 0;
      lock = new ReentrantLock();
      counterIsNot2 = lock.newCondition();
    }

    public void increment() throws InterruptedException {
      try {
        if (lock.tryLock()) {
          log.info("Lock acquired");
        } else {
          log.info("Waiting on a lock");
          lock.lock();
        }

        log.info("Incrementing counter");
        count++;

        while (count == 2) {
          log.info("Need to wait on a condition, count is {}", count);
          counterIsNot2.await();
          log.info("Resuming, count is now {}", count);
        }

        log.info("Signalling all, counter is {}", count);
        counterIsNot2.signalAll();


      } finally {
        log.info("Releasing lock");
        lock.unlock();
      }
    }

    @Override
    public String toString() {
      return STR."MyCounter{count=\{count}\{'}'}";
    }
  }
}