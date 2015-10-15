package kru.ctci.chapter1.testing;

import org.junit.Test;

import kru.ctci.chapter1.Problem3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem3Test {

  Problem3 p3 = new Problem3();

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

  private void runInternalEvaluation(String s1, String s2, boolean expectedOutput) {
    assertEquals(expectedOutput, p3.arePermutations(s1, s2, Problem3.SolutionType.CountUnicode));
    assertEquals(expectedOutput, p3.arePermutations(s1, s2, Problem3.SolutionType.CountAscii));
    assertEquals(expectedOutput, p3.arePermutations(s1, s2, Problem3.SolutionType.Sort));
    assertEquals(expectedOutput, p3.arePermutations(s2, s1, Problem3.SolutionType.CountUnicode));
    assertEquals(expectedOutput, p3.arePermutations(s2, s1, Problem3.SolutionType.CountAscii));
    assertEquals(expectedOutput, p3.arePermutations(s2, s1, Problem3.SolutionType.Sort));
  }

  @Test
  public void evaluationTest1() {
    String s1 = "assignment";
    String s2 = "atensginms";
    runInternalEvaluation(s1, s2, true);
  }

  @Test
  public void evaluationTest2() {
    String s1 = "burek";
    String s2 = "jogurt";
    runInternalEvaluation(s1, s2, false);
  }

  @Test
  public void evaluationTest3() {
    String s1 = "testing123";
    String s2 = "testing123";
    runInternalEvaluation(s1, s2, true);
  }

  @Test
  public void evaluationTest4() {
    String s1 = "salama";
    String s2 = "aaamls";
    runInternalEvaluation(s1, s2, true);
  }

  @Test
  public void evaluationTest5() {
    String s1 = "muzikhoren";
    String s2 = "horenmuzik";
    runInternalEvaluation(s1, s2, true);
  }
}