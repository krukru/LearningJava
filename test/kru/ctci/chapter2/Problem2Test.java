package kru.ctci.chapter2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import kru.collections.LinkedList;

public class Problem2Test {

  Problem2 p2 = new Problem2();
  LinkedList<Integer> list = new LinkedList<>();

  @Test
  public void testFindKthLastElement() {
    for (int i = 1; i <= 100; i++) {
      list.add(i);
    }
    assertEquals(100, p2.findKthLastElement(list, 1).intValue());
    assertEquals(99, p2.findKthLastElement(list, 2).intValue());
    assertEquals(1, p2.findKthLastElement(list, 100).intValue());
    assertEquals(2, p2.findKthLastElement(list, 99).intValue());
    try {
      p2.findKthLastElement(list, 0);
      fail();
    } catch (Exception e) {
      /* all good */
    }
    try {
      p2.findKthLastElement(list, 101);
      fail();
    } catch (Exception e) {
      /* all good */
    }
  }
}