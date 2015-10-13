package kru.ctci.chapter1.tests;

import org.junit.Test;

import kru.ctci.chapter1.Problem2;

import static org.junit.Assert.*;

public class Problem2Test {

  @Test
  public void testReverse() throws Exception {
    Problem2 p2 = new Problem2();
    char[] input1 = new char[]{'1', '2', '3', '\0'};
    char[] input2 = new char[]{'1', '2', '3', '4', '\0'};
    char[] input3 = new char[]{'\0'};
    p2.reverse(input1);
    p2.reverse(input2);
    p2.reverse(input3);
    assertArrayEquals(new char[]{'3','2','1','\0'}, input1);
    assertArrayEquals(new char[]{'4', '3','2','1','\0'}, input2);
    assertArrayEquals(new char[]{'\0'}, input3);
  }
}