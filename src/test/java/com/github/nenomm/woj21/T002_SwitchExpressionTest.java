package com.github.nenomm.woj21;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.jupiter.api.Test;

class T002_SwitchExpressionTest {

  @Test
  public void arrowStyle() {
    Integer randomCode = (int) (Math.random() * Integer.MAX_VALUE);

    if (randomCode > 1000) {
      randomCode = null;
    }

    int result = switch (randomCode) {
      case null -> 0;
      case 1 -> {
        yield 2;
      }
      case 4 -> 3;
      default -> 5;
    };

    // default does not match null :)

    assertThat(result, allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(10)));
  }

  @Test
  public void colonStyle() {
    Integer randomCode = (int) (Math.random() * Integer.MAX_VALUE);

    if (randomCode > 1000) {
      randomCode = null;
    }

    final int x = 23;

    int result = switch (randomCode) {
      case null:
        yield 0;
      case 1: {
        yield 2;
      }
      case x:
        yield 3;
      default:
        yield 5;
    };

    assertThat(result, allOf(greaterThanOrEqualTo(0), lessThanOrEqualTo(10)));
  }


}