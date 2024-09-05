package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class T006_InstanceOfPatternMatchingTest {

  static class A {

  }

  static class B extends A {

    public void methodOfB() {
    }

  }

  @Test
  public void instanceOfPatternMatching() {

    assertAll(() -> {
      A b = new B();

      if (b instanceof B ofBClass) {
        ofBClass.methodOfB();
      }

    });
  }

  static record TestRecord(int a, int b) {

  }

  @Test
  public void destructuring() {
    assertAll(() -> {
      TestRecord tr = new TestRecord(1, 2);

      if (tr instanceof TestRecord(var x, _)) {
        int w = x + 1;
      }
    });
  }
}