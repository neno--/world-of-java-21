package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

class T009_ProxyTest {

  @Test
  public void dynamicInvocation() {
    class LoggingHandler implements InvocationHandler {

      int counter = 0;
      final Runnable runnable;

      public LoggingHandler(Runnable runnable) {
        this.runnable = runnable;
      }

      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(STR."Invoking \{method} on an \{proxy.getClass()}");
        counter++;
        return method.invoke(this.runnable, args);
      }

      public int getCounter() {
        return this.counter;
      }
    }

    final LoggingHandler loggingHandler = new LoggingHandler(() -> System.out.println("Working..."));

    Object proxy = Proxy.newProxyInstance(
        ClassLoader.getSystemClassLoader(),
        new Class[]{Runnable.class}, loggingHandler);

    ((Runnable) proxy).run();

    assertEquals(1, loggingHandler.getCounter());
  }
}