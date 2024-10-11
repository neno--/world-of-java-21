package com.github.nenomm.woj21.threading.executors;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {

  public static void main(String[] args) {

    try (ExecutorService es = Executors.newSingleThreadExecutor()) {
      es.execute(() -> {
        System.out.println("Hello World!");
        try {
          Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
    }
  }
}
