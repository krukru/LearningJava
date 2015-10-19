package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;

public class Problem5 {

  public <E extends Comparable<E>> boolean isBinarySearchTree(BinaryTree<E> tree) {
    return isSubTreeBST(tree.root.leftChild, null, tree.root.data) &&
        isSubTreeBST(tree.root.rightChild, tree.root.data, null);
  }

  private <E extends Comparable<E>> boolean isSubTreeBST(Node<E> node, E minValue, E maxValue) {
    if (node == null) {
      return true;
    }
    if (minValue != null && node.data.compareTo(minValue) < 0 || maxValue != null && node.data
        .compareTo(maxValue) > 0) {
      return false;
    }

    boolean leftChildOk;
    leftChildOk = node.leftChild == null || isSubTreeBST(node.leftChild, minValue, node.data);
    boolean result = leftChildOk && (node.rightChild == null || isSubTreeBST(node.rightChild,
        node.data, maxValue));
    return result;
  }
}
