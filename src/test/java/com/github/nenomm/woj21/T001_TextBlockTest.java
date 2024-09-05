package com.github.nenomm.woj21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class T001_TextBlockTest {

  @Test
  public void simpleTextBlock() {
    String greeting = "Hello World!";
    assertEquals("Hello World!", greeting);

    greeting = """
        <div>
          <b>hi</b>
        </div>
        """;
    assertEquals("<div>\n  <b>hi</b>\n</div>\n", greeting);

    greeting = """
<div>
  <b>hi</b>
</div>
""";
    assertEquals("<div>\n  <b>hi</b>\n</div>\n", greeting);

    greeting = """
        <div>
          <b>hi</b>
          </div>
        """;
    assertEquals("<div>\n  <b>hi</b>\n  </div>\n", greeting);

    greeting = """
        <div>
          <b>hi</b>       
        </div>
        """;
    assertEquals("<div>\n  <b>hi</b>\n</div>\n", greeting);

    greeting = """
        <div>
          <b>hi</b>      \s
        </div>
        """;
    assertEquals("<div>\n  <b>hi</b>       \n</div>\n", greeting);

    greeting = """
        
         <div>
          <b>hi</b>       
        </div>
        """;
    assertEquals("\n <div>\n  <b>hi</b>\n</div>\n", greeting);
  }

  @Test
  public void complexTextBlock() {
    String greeting = """
        <div>\
          <b>hi</b>\
        </div>\
        """;
    assertEquals("<div>  <b>hi</b></div>", greeting);

    greeting = """
        <div>\
          <b>hi</b>   \
        </div>\
        """;
    assertEquals("<div>  <b>hi</b>   </div>", greeting);

    greeting = """
        <div>
          <b>hi</b>
        </div>
    """;
    assertEquals("    <div>\n      <b>hi</b>\n    </div>\n", greeting);
  }

}