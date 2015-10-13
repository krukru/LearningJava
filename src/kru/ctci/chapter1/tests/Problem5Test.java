package kru.ctci.chapter1.tests;

import org.junit.Test;

import kru.ctci.chapter1.Problem5;

import static org.junit.Assert.*;

public class Problem5Test {

  @Test
  public void testSimpleCompress_CompressionDidNotFinishInLoop1() {
    Problem5 p5 = new Problem5();
    String input = "aaaa";
    String expectedOutput = "a4";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionDidNotFinishInLoop2() {
    Problem5 p5 = new Problem5();
    String input = "aaaabbbbccccdddd";
    String expectedOutput = "a4b4c4d4";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionFinishInLoop1() {
    Problem5 p5 = new Problem5();
    String input = "aaaaab";
    String expectedOutput = "a5b1";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }

  @Test
  public void testSimpleCompress_CompressionIsLongerThanOriginal() {
    Problem5 p5 = new Problem5();
    String input = "abcdefg";
    String expectedOutput = "abcdefg";
    assertEquals(expectedOutput, p5.simpleCompress(input));
  }
}