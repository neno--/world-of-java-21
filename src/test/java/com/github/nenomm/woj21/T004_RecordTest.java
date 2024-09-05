package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class T004_RecordTest {

  @Test
  public void coordsAreFine() {
    record Point(int x, int y) {
      public Point {
        // compact constructor comes before the canonical
        x = x + 1;
      }

      public Point(int x) {
        this(x, x);
        int v = 23;
      }
    }

    assertEquals(2, (new Point(1,10)).x());
  }
}