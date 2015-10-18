package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1Test {

  private Problem1 p1 = new Problem1();

  @Test
  public void testIsBalanced_PositiveTest() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>();
    tree.root.leftChild = new Node();
    tree.root.rightChild = new Node();
    tree.root.leftChild.leftChild = new Node();
    tree.root.leftChild.rightChild = new Node();
    tree.root.rightChild.leftChild = new Node();
    tree.root.rightChild.rightChild = new Node();
    assertTrue(p1.isBalanced(tree));
  }

  @Test
  public void testIsBalanced_NegativeTest() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>();
    tree.root.leftChild = new Node();
    tree.root.rightChild = new Node();
    tree.root.leftChild.leftChild = new Node();
    tree.root.leftChild.rightChild = new Node();
    tree.root.leftChild.leftChild.leftChild = new Node();
    tree.root.leftChild.leftChild.rightChild = new Node();
    assertFalse(p1.isBalanced(tree));
  }

  @Test
  public void testIsBalanced_NegativeTest_QuickCutoffTest() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>();
    tree.root.leftChild = new Node();
    tree.root.leftChild.leftChild = new Node();
    tree.root.leftChild.leftChild.leftChild = new Node();
    tree.root.leftChild.leftChild.leftChild.leftChild = new Node();
    tree.root.leftChild.leftChild.leftChild.leftChild.leftChild = new Node();
    assertFalse(p1.isBalanced(tree));
  }
}
