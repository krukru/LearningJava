package kru.regex;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleRegexTest {

  SimpleRegex regex = new SimpleRegex();

  @Test
  public void basicTest1() throws Exception {
    String input = "abc";
    String pattern = "abc";
    assertTrue(regex.matchesPattern(pattern, input));
  }

  @Test
  public void basicTest2() throws Exception {
    String input = "abc";
    String pattern = "a?c";
    assertTrue
        (regex.matchesPattern(pattern, input));
  }
  @Test
  public void basicTest3() throws Exception {
    String input = "abbcc";
    String pattern = "a*c";
    assertTrue(regex.matchesPattern(pattern, input));
  }

  @Test
  public void testMatchesPattern_PositiveTest() throws Exception {
    String input = "Hey this is a real easy test";
    String pattern = "Hey?this*easy*st*";
    assertTrue(regex.matchesPattern(pattern, input));
  }

  @Test
  public void testMatchesPattern_EndingStar() throws Exception {
    String input = "hey";
    String pattern = "hey*";
    assertTrue(regex.matchesPattern(pattern, input));
  }

  @Test
  public void testMatchesPattern_NegativeTest() throws Exception {
    String input = "Hey this is a real easy test";
    String pattern = "H???this*easy*st?";
    assertTrue(regex.matchesPattern(pattern, input));
  }
}
