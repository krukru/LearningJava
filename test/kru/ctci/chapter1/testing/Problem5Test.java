package kru.ctci.chapter1.testing;

import org.junit.Test;

import kru.ctci.chapter1.Problem5;

import static org.junit.Assert.assertEquals;

public class Problem5Test {

  Problem5 p5 = new Problem5();

  @Test
  public void testSimpleCompress_CompressionDidNotFinishInLoop1() {
    String input = "aaaa";
    String expectedOutput = "a4";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionDidNotFinishInLoop2() {
    String input = "aaaabbbbccccdddd";
    String expectedOutput = "a4b4c4d4";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionFinishInLoop1() {
    String input = "aaaaab";
    String expectedOutput = "a5b1";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionIsLongerThanOriginal() {
    String input = "abcdefg";
    String expectedOutput = "abcdefg";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void evaluationTest1() {
    String input = "a";
    String expectedOutput = "a";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void evaluationTest2() {
    String input = "aaaaaaaaaa";
    String expectedOutput = "a10";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void evaluationTest3() {
    String input = "aaAAaaAA";
    String expectedOutput = "aaAAaaAA";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void evaluationTest4() {
    String input = "aaaaaaaaaaAAAAAAAAAA";
    String expectedOutput = "a10A10";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void evaluationTest5() {
    String input = "aaaaaaaaaaAa";
    String expectedOutput = "a10A1a1";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }
}