package kru.ctci.chapter2;

import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Random;

import kru.collections.HashSet;
import kru.collections.LinkedList;

public class Problem1Test {

  Problem1 p1 = new Problem1();
  private LinkedList<Integer> list = new LinkedList<>();

  @Test
  public void basicNonDeterministicTest() {
    Random rnd = new Random();
    for (int i = 0; i < 10000; i++) {
      list.add(rnd.nextInt(50));
    }
    p1.removeDuplicates(list);
    HashSet<Integer> lookup = new HashSet<>();
    for (int element : list) {
      if (lookup.contains(element)) {
        fail("Duplicate found");
      }
      else {
        lookup.add(element);
      }
    }
  }
}
