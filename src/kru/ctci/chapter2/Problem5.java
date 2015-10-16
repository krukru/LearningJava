package kru.ctci.chapter2;

import java.util.Iterator;

import kru.collections.LinkedList;

/**
 * Problem description:
 *
 * You are given two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write
 * a function that adds the two numbers and returns the sum as a linked list.
 *
 * Follow up question: Suppose the digits are stored in forward order
 */

public class Problem5 {
  public LinkedList<Integer> sumReverseDecimalRepresentation(LinkedList<Integer> list1,
                                                             LinkedList<Integer> list2) {
    LinkedList<Integer> result = new LinkedList<>();
    Iterator<Integer> it1 = list1.iterator();
    Iterator<Integer> it2 = list2.iterator();
    int carry = 0;
    while (it1.hasNext() || it2.hasNext()) {
      int digit1 = it1.hasNext() ? it1.next() : 0;
      int digit2 = it2.hasNext() ? it2.next() : 0;
      if (digit1 < 0 || digit1 > 9 || digit2 < 0 || digit2 > 9) {
        throw new IllegalArgumentException("Contract violation");
      }
      int sum = digit1 + digit2 + carry;
      int newDigit = sum % 10;
      carry = sum / 10;
      result.add(newDigit);
    }
    return result;
  }

  public LinkedList<Integer> sumDecimalRepresentation(LinkedList<Integer> list1,
                                                      LinkedList<Integer> list2) {
    while (list1.size() < list2.size()) {
      list1.addFirst(0);
    }
    while (list2.size() < list1.size()) {
      list2.addFirst(0);
    }
    return recursiveSum(list1, list2);
  }

  private LinkedList<Integer> recursiveSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    LinkedList<Integer> result = new LinkedList<>();
    IntWrapper outCarry = new IntWrapper(); /* will get changed in the recursion */
    recursiveAdd(result, list1.iterator(), list2.iterator(), outCarry);
    return result;
  }

  private void recursiveAdd(LinkedList<Integer> result, Iterator<Integer> it1,
                            Iterator<Integer> it2, IntWrapper outCarry) {
    if (it1.hasNext() == false && it2.hasNext() == false) {
      /* we've reached the end. Start bubbling the carry */
      outCarry.value = 0;
      return;
    }
    int digit1 = it1.hasNext() ? it1.next() : 0;
    int digit2 = it2.hasNext() ? it2.next() : 0;
    recursiveAdd(result, it1, it2, outCarry);
    int newDigit = (digit1 + digit2 + outCarry.value) % 10;
    outCarry.value = (digit1 + digit2) / 10;
    result.addFirst(newDigit); /* always push to the beginning of the list */
  }

  private class IntWrapper {

    public IntWrapper() {

    }

    public IntWrapper(int value) {
      this.value = value;
    }

    public Integer value;
  }

}
