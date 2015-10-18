package kru.ctci.chapter4;

import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;
import kru.util.Wrappable;

public class Problem1 {

  public <E> boolean isBalanced(BinaryTree tree) {
    Wrappable<Boolean> canBeBalanced = new Wrappable<>(true);
    return isBalanced(tree.root, canBeBalanced);
  }

  public boolean isBalanced(Node node, Wrappable<Boolean> canBeBalanced) {
    if (node == null) {
      return true;
    }
    int leftSubtreeHeight = height(node.leftChild, canBeBalanced);
    int rightSubtreeHeight;
    if (canBeBalanced.getValue()) {
      rightSubtreeHeight = height(node.rightChild, canBeBalanced);
      canBeBalanced.setValue(Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1);
      return canBeBalanced.getValue();
    } else {
      return false;
    }
  }

  private int height(Node startingNode, Wrappable<Boolean> canBeBalanced) {
    if (startingNode == null) {
      return 0;
    }
    return Math.max(height(startingNode.leftChild, canBeBalanced), height(startingNode
        .rightChild, canBeBalanced)) + 1;
  }
}
