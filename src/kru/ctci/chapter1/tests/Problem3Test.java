package kru.ctci.chapter1.tests;

import org.junit.Test;

import kru.collections.ArrayList;
import kru.ctci.chapter1.Problem3;

import static org.junit.Assert.*;

public class Problem3Test {

  @Test
  public void testArePermutations_MethodSorting() throws Exception {
    runTest(Problem3.SolutionType.Sort);
  }

  @Test
  public void testArePermutations_MethodAscii() throws Exception {
    runTest(Problem3.SolutionType.CountAscii);
  }

  @Test
  public void testArePermutations_MethodUnicode() throws Exception {
    runTest(Problem3.SolutionType.CountUnicode);
  }

  private void runTest(Problem3.SolutionType st) {
    Problem3 p3 = new Problem3();

    String a1 = "abc";
    String a2 = "abc";
    assertTrue(p3.arePermutations(a1, a2, st));

    String b1 = "hat";
    String b2 = "TaH";
    assertTrue(p3.arePermutations(b1, b2, st));

    String c1 = "U tebi je srbin";
    String c2 = "Justin Bieber";
    assertTrue(p3.arePermutations(c1, c2, st));

    String d1 = "Ana voli milovana";
    String d2 = "Tražimo anagrame, ne palindrome";
    assertFalse(p3.arePermutations(d1, d2, st));

    String e1 = "Punctuations   and spaces don't matter.";
    String e2 = "Punctuations and spaces dont matter ?    ";
    assertTrue(p3.arePermutations(e1, e2, st));

    String f1 = "Über";
    String f2 = "Über";
    assertTrue(p3.arePermutations(f1, f2, st));
  }
}