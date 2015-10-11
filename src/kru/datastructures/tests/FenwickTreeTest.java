package kru.datastructures.tests;

import kru.collections.ArrayList;
import kru.datastructures.FenwickTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FenwickTreeTest {
  @Test
  public void basicTest() {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < 10000; i++) {
      list.add(i);
    }
    FenwickTree ft = new FenwickTree(list);
    assertEquals(1, ft.getSum(1));
  }
}


