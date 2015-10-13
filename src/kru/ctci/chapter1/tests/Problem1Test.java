package kru.ctci.chapter1.tests;

import static org.junit.Assert.*;

import kru.ctci.chapter1.Problem1;

import org.junit.Test;

public class Problem1Test {

  @Test
  public void testAreAllCharactersUnique() throws Exception {
    Problem1 p1 = new Problem1();
    String input1 = "abc";
    String input2 = "abca";
    String input3 = "";
    String input4 = "aA";
    String input5 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&/()=?*";
    assertTrue(p1.areAllCharactersUnique(input1));
    assertFalse(p1.areAllCharactersUnique(input2));
    assertTrue(p1.areAllCharactersUnique(input3));
    assertTrue(p1.areAllCharactersUnique(input4));
    assertTrue(p1.areAllCharactersUnique(input5));
  }
}