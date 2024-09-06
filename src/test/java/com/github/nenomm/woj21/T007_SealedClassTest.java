package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class T007_SealedClassTest {

  static sealed abstract class A permits B, C {

  }

  static final class B extends A {

  }

  static non-sealed class C extends A {

  }

  @Test
  public void template() {
    A b = new B();

    assertEquals(B.class, b.getClass());
  }
}