package com.github.nenomm.woj21;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.Test;

class T008_CaseGuardTest {

  @Test
  public void colonStyle() {
    Integer randomCode = (int) (Math.random() * Integer.MAX_VALUE);

    int x = 23;

    int result = switch (randomCode) {
      // guards are only applicable to pattern expressions
      case Number _ when x > 34: {
        yield 2;
      }
      case Object o when o.toString().length() > 3: {
        yield 2;
      }
      case null, default:
        yield 0;
    };

    assertThat(result, allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(10)));
  }
}