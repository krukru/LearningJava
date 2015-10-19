package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;

public class Problem5 {

  public <E extends Comparable<E>> boolean isBinarySearchTree(BinaryTree<E> tree) {
    return isLeftSubTreeBST(tree.root.leftChild, tree.root.data, tree.root.data) &&
        isRightSubTreeBST(tree.root.rightChild, tree.root.data, tree.root.data);
  }

  private <E extends Comparable<E>> boolean isLeftSubTreeBST(Node<E> node, E minValue, E maxValue) {
    if (node == null) {
      return true;
    }
    if (node.data.compareTo(minValue) > 0 || node.data.compareTo(maxValue) < 0) {
      return false;
    }
    boolean leftChildOk;
    leftChildOk = node.leftChild == null || isLeftSubTreeBST(node.leftChild, min(minValue, node
        .data), max(maxValue, node.data));
    boolean result = leftChildOk && (node.rightChild == null || isRightSubTreeBST(node
        .rightChild, node.data, max(maxValue, node.data)));
    return result;
  }

  private <E extends Comparable<E>> boolean isRightSubTreeBST(Node<E> node, E minValue, E
      maxValue) {
    if (node == null) {
      return true;
    }
    if (node.data.compareTo(maxValue) < 0 || node.data.compareTo(minValue) > 0) {
      return false;
    }
    boolean leftChildOk;
    leftChildOk = node.leftChild == null || isLeftSubTreeBST(node.leftChild, min(minValue, node
        .data), node.data);
    boolean result = leftChildOk && (node.rightChild == null || isRightSubTreeBST(node
        .rightChild, min(minValue, node.data), max(maxValue, node.data)));
    return result;
  }

  private <E extends Comparable<E>> E min(E item1, E item2) {
    if (item1.compareTo(item2) <= 0) {
      return item1;
    } else {
      return item2;
    }
  }

  private <E extends Comparable<E>> E max(E item1, E item2) {
    if (item1.compareTo(item2) >= 0) {
      return item1;
    } else {
      return item2;
    }
  }
}
