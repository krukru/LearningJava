package kru.ctci.chapter4;

import kru.collections.ArrayList;
import kru.trees.binarytree.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem6Test {

  Problem6 p6 = new Problem6();

  @Test
  public void testBST_DFSiterator() throws Exception {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.add(5);
    tree.add(7);
    tree.add(2);
    tree.add(3);
    tree.add(1);
    tree.add(8);
    tree.add(6);
    ArrayList<Integer> expectedResult = new ArrayList<>();
    expectedResult.add(5);
    expectedResult.add(2);
    expectedResult.add(1);
    expectedResult.add(3);
    expectedResult.add(7);
    expectedResult.add(6);
    expectedResult.add(8);
    assertEquals(expectedResult, p6.iterateTree(tree));
  }

  @Test
  public void testIsBinarySearchTree_NegativeTest2() throws Exception {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.add(100);
    tree.add(5);
    tree.add(300);
    ArrayList<Integer> expectedResult = new ArrayList<>();
    expectedResult.add(100);
    expectedResult.add(5);
    expectedResult.add(300);
    assertEquals(expectedResult, p6.iterateTree(tree));
  }
}
