package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class T005_InterpolatorTest {

  @Test
  public void template() {
    int x = 42;
    String str = STR."Hello, \{x}!";

    assertEquals("Hello, 42!", str);
  }
}