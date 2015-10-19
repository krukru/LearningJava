package kru.ctci.chapter4;

import kru.collections.ArrayList;
import kru.trees.binarytree.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem3Test {

  Problem3 p3 = new Problem3();

  @Test
  public void testFillBinarySearchTree() throws Exception {
    ArrayList<Integer> sortedList = new ArrayList<>();
    for (int i = 0; i < 1024; i++) {
      sortedList.add(i);
    }
    BinarySearchTree bst = p3.fillBinarySearchTree(sortedList);
    assertEquals(1024, bst.size());
    assertEquals(11, bst.height());
  }
}
