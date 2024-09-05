package com.github.nenomm.woj21;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.Test;

class T003_SwitchStatementTest {

  @Test
  public void arrowStyle() {
    Integer randomCode = (int) (Math.random() * Integer.MAX_VALUE);

    if (randomCode > 1000) {
      randomCode = null;
    }

    int result;

    switch (randomCode) {
      case null -> result = 0;
      case 1 -> {
        int c = 45;
        result = 3;
      }
      case 4 -> result = 5;
      default -> result = 6;
    }

    assertThat(result, allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(10)));

    // Avoid the fallthrough forms. It is very uncommon to need fallthrough.
    // Prefer switch expressions over statements.

  }
}