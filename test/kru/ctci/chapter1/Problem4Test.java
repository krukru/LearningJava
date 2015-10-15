package kru.ctci.chapter1;

import org.junit.Test;

import java.util.Arrays;

import kru.ctci.chapter1.Problem4;

import static org.junit.Assert.assertArrayEquals;

public class Problem4Test {

  Problem4 p4 = new Problem4();

  @Test
  public void testReplaceSpacesWithPercent20() {
    String input = "Hey why don't we replace all the spaces!";
    String solution = input.replace(" ", "%20");
    char[] inputArray = Arrays.copyOf(input.toCharArray(), solution.length());
    p4.replaceSpacesWithPercent20(inputArray);
    assertArrayEquals(solution.toCharArray(), inputArray);
  }

  private void runInternalValidation(String input, String expectedOutput) {
    char[] inputArray = Arrays.copyOf(input.toCharArray(), expectedOutput.length());
    p4.replaceSpacesWithPercent20(inputArray);
    assertArrayEquals(expectedOutput.toCharArray(), inputArray);
  }

  @Test
  public void evaluationTest1() {
    String input = " Lorem      ipsum   picka  materina.";
    String expectedOutput = "%20Lorem%20%20%20%20%20%20ipsum%20%20%20picka%20%20materina.";
    runInternalValidation(input, expectedOutput);
  }

  @Test
  public void evaluationTest2() {
    String input = "well, here-we-go";
    String expectedOutput = "well,%20here-we-go";
    runInternalValidation(input, expectedOutput);
  }

  @Test
  public void evaluationTest3() {
    String input = "nothing-to-replace-here";
    String expectedOutput = "nothing-to-replace-here";
    runInternalValidation(input, expectedOutput);
  }
}