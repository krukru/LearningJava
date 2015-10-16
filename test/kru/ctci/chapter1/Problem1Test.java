package kru.ctci.chapter1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Problem1Test {

  Problem1 p1 = new Problem1();

  @Test
  public void testAreAllCharactersUnique() {
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

  @Test
  public void evaluationTest1() {
    assertTrue(p1.areAllCharactersUnique("a"));
  }

  @Test
  public void evaluationTest2() {
    assertTrue(p1.areAllCharactersUnique("abcdefghijklmnopqrstuvwxyz"));
  }

  @Test
  public void evaluationTest3() {
    assertTrue(p1.areAllCharactersUnique("abA"));
  }

  @Test
  public void evaluationTest4() {
    assertFalse(p1.areAllCharactersUnique("aba"));
  }

  @Test
  public void evaluationTest5() {
    assertFalse(p1.areAllCharactersUnique("ZZZZZ"));
  }
}