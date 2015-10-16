package kru.ctci.chapter2;

import static org.junit.Assert.*;

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
    LinkedList<Integer> expetedList = new LinkedList<>();
    expetedList.add(0);
    assertEquals(expetedList, p5.sumReverseDecimalRepresentation(list1, list2));
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
    LinkedList<Integer> expetedList = new LinkedList<>();
    /* sum is 655046 */
    expetedList.add(6);
    expetedList.add(4);
    expetedList.add(0);
    expetedList.add(5);
    expetedList.add(5);
    expetedList.add(6);
    assertEquals(expetedList, p5.sumReverseDecimalRepresentation(list1, list2));
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
    LinkedList<Integer> expetedList = new LinkedList<>();
    /* sum is 123983 */
    expetedList.add(1);
    expetedList.add(2);
    expetedList.add(3);
    expetedList.add(9);
    expetedList.add(8);
    expetedList.add(3);
    assertEquals(expetedList, p5.sumReverseDecimalRepresentation(list1, list2));
  }
}