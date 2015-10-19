package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem5Test {

  Problem5 p5 = new Problem5();

  @Test
  public void testIsBinarySearchTree_PositiveTest() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>(5);
    tree.root.leftChild = new Node<>(2);
    tree.root.leftChild.leftChild = new Node<>(1);
    tree.root.leftChild.rightChild = new Node<>(3);
    tree.root.rightChild = new Node<>(7);
    tree.root.rightChild.leftChild = new Node<>(6);
    tree.root.rightChild.rightChild = new Node<>(8);
    assertTrue(p5.isBinarySearchTree(tree));
  }

  @Test
  public void testIsBinarySearchTree_NegativeTest() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>(5);
    tree.root.leftChild = new Node<>(2);
    tree.root.leftChild.leftChild = new Node<>(1);
    tree.root.leftChild.rightChild = new Node<>(3);
    tree.root.rightChild = new Node<>(7);
    tree.root.rightChild.leftChild = new Node<>(6);
    tree.root.rightChild.rightChild = new Node<>(0);
    assertFalse(p5.isBinarySearchTree(tree));
  }
}
