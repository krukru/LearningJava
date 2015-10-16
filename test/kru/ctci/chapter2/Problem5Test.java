package kru.ctci.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kru.collections.LinkedList;

public class Problem5Test {

  Problem5 p5 = new Problem5();
  LinkedList<Integer> list1 = new LinkedList<>();
  LinkedList<Integer> list2 = new LinkedList<>();

  @Test
  public void testSumReverseDecimalRepresentation1() {
    list1.add(0);
    list2.add(0);
    LinkedList<Integer> expectedList = new LinkedList<>();
    expectedList.add(0);
    assertEquals(expectedList, p5.sumReverseDecimalRepresentation(list1, list2));
  }

  @Test
  public void testSumReverseDecimalRepresentation2() {
    /* number1 is 654321 */
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    list1.add(6);
    /* number2 is 725 */
    list2.add(5);
    list2.add(2);
    list2.add(7);
    LinkedList<Integer> expectedList = new LinkedList<>();
    /* sum is 655046 */
    expectedList.add(6);
    expectedList.add(4);
    expectedList.add(0);
    expectedList.add(5);
    expectedList.add(5);
    expectedList.add(6);
    LinkedList<Integer> sum = p5.sumReverseDecimalRepresentation(list1, list2);
    assertEquals(expectedList, sum);
  }

  @Test
  public void testSumDecimalRepresentation() {
    /* number1 is 123456 */
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    list1.add(6);
    /* number2 is 527 */
    list2.add(5);
    list2.add(2);
    list2.add(7);
    LinkedList<Integer> expectedList = new LinkedList<>();
    /* sum is 123983 */
    expectedList.add(1);
    expectedList.add(2);
    expectedList.add(3);
    expectedList.add(9);
    expectedList.add(8);
    expectedList.add(3);
    LinkedList<Integer> result = p5.sumDecimalRepresentation(list1, list2);
    assertEquals(expectedList, result);
  }

  @Test
  public void bookExample1() {
    /* number1 is 716 */
    list1.add(7);
    list1.add(1);
    list1.add(6);
    /* number2 is 592 */
    list2.add(5);
    list2.add(9);
    list2.add(2);
    LinkedList<Integer> expectedList = new LinkedList<>();
    /* sum is 219 */
    expectedList.add(2);
    expectedList.add(1);
    expectedList.add(9);
    LinkedList<Integer> result = p5.sumReverseDecimalRepresentation(list1, list2);
    assertEquals(expectedList, result);
  }

  @Test
  public void bookExample2() {
    /* number1 is 716 */
    list1.add(6);
    list1.add(1);
    list1.add(7);
    /* number2 is 592 */
    list2.add(2);
    list2.add(9);
    list2.add(5);
    LinkedList<Integer> expectedList = new LinkedList<>();
    /* sum is 219 */
    expectedList.add(9);
    expectedList.add(1);
    expectedList.add(2);
    LinkedList<Integer> result = p5.sumDecimalRepresentation(list1, list2);
    assertEquals(expectedList, result);
  }
}