package kru.ctci.chapter2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kru.collections.LinkedList;

public class Problem7Test {

  Problem7 p7 = new Problem7();
  LinkedList<String> list = new LinkedList<>();

  @Test
  public void testIsPalindrome_PositiveTest() {
    list.add("A");
    list.add("N");
    list.add("A");
    list.add(" ");
    list.add("V");
    list.add("O");
    list.add("L");
    list.add("I");
    list.add(" ");
    list.add(" "); /* note the double spaces */
    list.add("M");
    list.add("I");
    list.add("L");
    list.add("O");
    list.add("V");
    list.add("A");
    list.add("N");
    list.add("A");
    assertTrue(p7.isPalindrome(list));
  }

  @Test
  public void testIsPalindrome_NegativeTest() {
    list.add("O");
    list.add("B");
    list.add("V");
    list.add("I");
    list.add("O");
    list.add("U");
    list.add("S");
    list.add("L");
    list.add("Y");
    list.add(" ");
    list.add("N");
    list.add("O");
    list.add("T");
    list.add(" ");
    list.add("A");
    list.add(" ");
    list.add("P");
    list.add("A");
    list.add("L");
    list.add("I");
    list.add("N");
    list.add("D");
    list.add("R");
    list.add("O");
    list.add("M");
    list.add("E");
    assertFalse(p7.isPalindrome(list));
  }
}