package kru.ctci.chapter4;

import kru.collections.HashMap;
import kru.collections.LinkedList;
import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem4Test {

  Problem4 p4 = new Problem4();

  @Test
  public void testToLinkedListMap() throws Exception {
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = new Node<>(1);
    tree.root.leftChild = new Node<>(2);
    tree.root.rightChild = new Node<>(2);
    tree.root.leftChild.leftChild = new Node<>(3);
    tree.root.leftChild.rightChild = new Node<>(3);
    tree.root.rightChild.leftChild = new Node<>(3);
    tree.root.rightChild.rightChild = new Node<>(3);
    tree.root.leftChild.leftChild.leftChild = new Node<>(4);
    tree.root.leftChild.leftChild.rightChild = new Node<>(4);
    tree.root.leftChild.rightChild.leftChild = new Node<>(4);
    tree.root.leftChild.rightChild.rightChild = new Node<>(4);
    tree.root.rightChild.leftChild.leftChild = new Node<>(4);
    tree.root.rightChild.leftChild.rightChild = new Node<>(4);
    tree.root.rightChild.rightChild.leftChild = new Node<>(4);
    tree.root.rightChild.rightChild.rightChild = new Node<>(4);
    HashMap<Integer, LinkedList<Integer>> result = p4.toLinkedListMap(tree);
    assertEquals(4, result.size());
    assertEquals(createLayer(1, 1), result.get(1));
    assertEquals(createLayer(2, 2), result.get(2));
    assertEquals(createLayer(4, 3), result.get(3));
    assertEquals(createLayer(8, 4), result.get(4));
  }

  private LinkedList<Integer> createLayer(int numberOfElements, int elementValue) {
    LinkedList<Integer> result = new LinkedList<>();
    for (int i = 0; i < numberOfElements; i++) {
      result.addLast(elementValue);
    }
    return result;
  }
}
