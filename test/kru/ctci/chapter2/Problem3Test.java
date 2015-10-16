package kru.ctci.chapter2;

import static org.junit.Assert.*;

import org.junit.Test;

import kru.collections.LinkedList;

public class Problem3Test {

  Problem3 p3 = new Problem3();


  @Test
  public void testRemove() throws Exception {
    LinkedList<Integer> list = new LinkedList<>();
    LinkedList<Integer> expectedList = new LinkedList<>();
    for (int i = 1; i <= 100; i++) {
      list.add(i);
      if (i == 5 || i == 50 || i == 95) {
        continue;
      }
      expectedList.add(i);
    }
    p3.remove(list, 5);
    p3.remove(list, 50);
    p3.remove(list, 95);
    assertTrue(expectedList.equals(list));
  }
}