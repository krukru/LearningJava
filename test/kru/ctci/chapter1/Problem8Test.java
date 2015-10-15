package kru.ctci.chapter1;

import org.junit.Test;

import kru.ctci.chapter1.Problem8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem8Test {

  private Problem8 p8 = new Problem8();

  @Test
  public void testBasic1_SameString_ExpectsTrue() {
    String s1 = "a";
    String s2 = "a";
    boolean areRotated = p8.isRotation(s1, s2);
    assertTrue(areRotated);
    areRotated = p8.isRotation(s1, s1);
    assertTrue(areRotated);
  }

  @Test
  public void testBasic2_SimpleRotation() {
    String s1 = "abcdefg";
    String s2 = "defgabc";
    boolean areRotated = p8.isRotation(s1, s2);
    assertTrue(areRotated);
  }

  @Test
  public void testBasic3_BigStrings_NoRotationExpectsFalse() {
    String s1 = "abcdefghijklmnopqrstuvwxyz";
    String s2 = "abcdefghijklmnopqrstuvwxy0";
    boolean areRotated = p8.isRotation(s1, s2);
    assertFalse(areRotated);
    areRotated = p8.isRotation(s2, s1);
    assertFalse(areRotated); /* should be obvious */
  }

  @Test
  public void testBasic4_BigString_CaseInsensitive_ExpectsTrue() {
    String s1 = "ABCDEFGhijkLMNOpqrstuvwxyz1234567890!";
    String s2 = "hijkLMNOPQrstuvwxyZ1234567890!abcdeFG";
    boolean areRotated = p8.isRotation(s1, s2);
    assertTrue(areRotated);
    areRotated = p8.isRotation(s2, s1);
    assertTrue(areRotated);
  }

  @Test
  public void testBasic5_EmptyStrings_ExpectsFalse() {
    String s1 = "";
    String s2 = "not empty";
    boolean areRotated = p8.isRotation(s1, s2);
    assertFalse(areRotated);
    areRotated = p8.isRotation(s2, s1);
    assertFalse(areRotated);
  }

  @Test
  public void testBasic6_EmptyStrings_ExpectsTrue() {
    String s1 = "";
    String s2 = "";
    boolean areRotated = p8.isRotation(s1, s2);
    assertTrue(areRotated);
  }

  @Test
  public void evaluationTest1() {
    String s1 = "watterbottle";
    String s2 = "erbottlewatt";
    assertTrue(p8.isRotation(s1, s2));
    assertTrue(p8.isRotation(s2, s1));
  }
}
