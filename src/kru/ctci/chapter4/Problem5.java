package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;

public class Problem5 {

  public <E extends Comparable<E>> boolean isBinarySearchTree(BinaryTree<E> tree) {
    return isBinarySearchTree(tree.root);
  }

  private <E extends Comparable<E>> boolean isBinarySearchTree(Node<E> node) {
    if (node == null) {
      return true;
    }
    boolean leftChildOk;
    boolean rightChildOk;
    if (node.leftChild != null) {
      leftChildOk = node.leftChild.data.compareTo(node.data) < 0 && isBinarySearchTree(node.leftChild);
    } else {
      leftChildOk = true;
    }
    if (node.rightChild != null) {
      rightChildOk = node.rightChild.data.compareTo(node.data) > 0 && isBinarySearchTree(node.rightChild);
    } else {
      rightChildOk = true;
    }
    return leftChildOk && rightChildOk;
  }
}
