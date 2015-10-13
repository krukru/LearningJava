package kru.ctci.chapter1.tests;

import org.junit.Test;

import java.util.Arrays;

import kru.ctci.chapter1.Problem4;

import static org.junit.Assert.*;

public class Problem4Test {

  @Test
  public void testReplaceSpacesWithPercent20() throws Exception {
    String input = "Hey why don't we replace all the spaces!";
    String solution = input.replace(" ", "%20");
    char[] inputArray = Arrays.copyOf(input.toCharArray(), solution.length());
    Problem4 p4 = new Problem4();
    p4.replaceSpacesWithPercent20(inputArray);
    assertArrayEquals(solution.toCharArray(), inputArray);
  }
}