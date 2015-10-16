package kru.ctci.chapter2;

import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import kru.collections.LinkedList;

public class Problem4Test {

  Random rnd = new Random();
  Problem4 p4 = new Problem4();
  LinkedList<Integer> list = new LinkedList<>();

  @Test
  public void testPartitionList() {
    final int bound = 50;
    final int partitionElement = 25;
    for (int i = 0; i < 1000; i++) {
      list.add(rnd.nextInt(bound));
    }
    LinkedList<Integer> partitionedList = p4.partitionList(list, partitionElement);
    Iterator<Integer> it = partitionedList.iterator();
    while (it.hasNext()) {
      int element = it.next();
      if (element > partitionElement) {
        break;
      }
    }
    while (it.hasNext()) {
      int element = it.next();
      if (element < partitionElement) {
        fail("Not partitioned well");
      }
    }
  }
}