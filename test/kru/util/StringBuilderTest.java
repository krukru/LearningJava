package kru.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;

public class StringBuilderTest {

  @Test
  public void basicSbTest() throws IOException {
    StringBuilder sb = new StringBuilder();
    runBasicTest(sb, sb, new String());
  }

  @Test
  public void basicSbWithInitialCapacityTest() throws IOException {
    StringBuilder sb = new StringBuilder(50);
    runBasicTest(sb, sb, new String());
  }

  @Test
  public void basicSbWithInitialStringTest() throws IOException {
    String initialString = "12345678";
    StringBuilder sb = new StringBuilder(initialString);
    runBasicTest(sb, sb, initialString);
  }

  @Test
  public void basicJavaSbTest() throws IOException {
    /* Here we are testing the tests */
    java.lang.StringBuilder sb = new java.lang.StringBuilder();
    runBasicTest(sb, sb, new String());
  }

  @Test
  public void basicJavaSbWithInitialCapacityTest() throws IOException {
    /* Here we are testing the tests */
    java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
    runBasicTest(sb, sb, new String());
  }

  @Test
  public void basicJavaSbWithInitialStringTest() throws IOException {
    /* Here we are testing the tests */
    String initialString = "12345678";
    java.lang.StringBuilder sb = new java.lang.StringBuilder(initialString);
    runBasicTest(sb, sb, initialString);
  }

  private void runBasicTest(Appendable appendable, CharSequence csq, String initialString) throws
      IOException {
    int offset = initialString.length();
    assertEquals(offset, csq.length());
    try {
      csq.charAt(offset);
      fail("This shouldn't happen");
    } catch (Exception e) {
      /* yea this is ok */
    }
    appendable.append('1');
    assertEquals(offset + 1, csq.length());
    assertEquals('1', csq.charAt(offset));
    appendable.append('2').append("345").append("12345678", 5, 8);
    assertTrue(appendable.toString().equals(initialString + "12345678"));
    assertEquals(offset + 8, csq.length());
    try {
      appendable.append("12345678", 5, 9);
      fail("This shouldn't happen");
    } catch (Exception e) {
      /* This is fine */
    }
    int numberOfCharsToAppend = 10000;
    for (int i = 0; i < numberOfCharsToAppend; i++) {
      appendable.append('X');
    }
    assertEquals(offset + 8 + numberOfCharsToAppend, csq.length());
    assertTrue(csq.subSequence(1, 8).equals("2345678"));
  }
}
