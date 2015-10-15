package kru.ctci.chapter1;

import org.junit.Test;

import kru.ctci.chapter1.Problem2;

import static org.junit.Assert.assertArrayEquals;

public class Problem2Test {

  Problem2 p2 = new Problem2();

  @Test
  public void testReverse() {
    char[] input1 = new char[]{'1', '2', '3', '\0'};
    char[] input2 = new char[]{'1', '2', '3', '4', '\0'};
    char[] input3 = new char[]{'\0'};
    p2.reverse(input1);
    p2.reverse(input2);
    p2.reverse(input3);
    assertArrayEquals(new char[]{'3', '2', '1', '\0'}, input1);
    assertArrayEquals(new char[]{'4', '3', '2', '1', '\0'}, input2);
    assertArrayEquals(new char[]{'\0'}, input3);
  }

  private char[] charify(String input) {
    return input.concat("\0").toCharArray();
  }

  private String reverse(String input) {
    return new StringBuilder(input).reverse().toString();
  }

  @Test
  public void evaluationTest1() {
    String input = "a";
    char[] inputAray = charify(input);
    char[] expectedOutput = charify(reverse(input));
    p2.reverse(inputAray);
    assertArrayEquals(expectedOutput, inputAray);
  }


  @Test
  public void evaluationTest2() {
    String input = "AaBcDeFgHaA";
    char[] inputAray = charify(input);
    char[] expectedOutput = charify(reverse(input));
    p2.reverse(inputAray);
    assertArrayEquals(expectedOutput, inputAray);
  }


  @Test
  public void evaluationTest3() {
    String input = "aaaA";
    char[] inputAray = charify(input);
    char[] expectedOutput = charify(reverse(input));
    p2.reverse(inputAray);
    assertArrayEquals(expectedOutput, inputAray);
  }

  @Test
  public void evaluationTest4() {
    String input = "ahugbairbhoerhenrithuobieUIAZGF()/&T#GFIGJBKAEGLKb";
    char[] inputAray = charify(input);
    char[] expectedOutput = charify(reverse(input));
    p2.reverse(inputAray);
    assertArrayEquals(expectedOutput, inputAray);
  }

  @Test
  public void evaluationTest5() {
    String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam fringilla " +
        "augue a eros faucibus pharetra. Proin facilisis, nibh eu laoreet sollicitudin, lacus est" +
        " consequat turpis, nec molestie ligula ipsum sed lorem. Ut id lorem luctus, consectetur " +
        "metus non, rhoncus magna. Pellentesque purus ipsum, mollis nec tristique sit amet, " +
        "eleifend in sapien. Duis eget mattis lacus. Sed auctor rutrum orci a tristique. Ut sit " +
        "amet augue ut libero posuere consectetur. Aliquam pretium facilisis ex ac porta. " +
        "Praesent imperdiet ante id elit cursus, non suscipit mauris imperdiet. Phasellus tempor " +
        "laoreet velit, efficitur rhoncus tellus luctus eu.";
    char[] inputAray = charify(input);
    char[] expectedOutput = charify(reverse(input));
    p2.reverse(inputAray);
    assertArrayEquals(expectedOutput, inputAray);
  }


}