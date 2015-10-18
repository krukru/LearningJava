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
    int leftSubtreeHeight = getBalanceHeight(node.leftChild, canBeBalanced);
    int rightSubtreeHeight;
    if (canBeBalanced.getValue()) {
      rightSubtreeHeight = getBalanceHeight(node.rightChild, canBeBalanced);
      canBeBalanced.setValue(Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1);
      return canBeBalanced.getValue();
    } else {
      return false;
    }
  }

  private int getBalanceHeight(Node startingNode, Wrappable<Boolean> canBeBalanced) {
    if (startingNode == null || canBeBalanced.getValue() == false) {
      return 0;
    }
    int leftHeight = getBalanceHeight(startingNode.leftChild, canBeBalanced);
    int rightHeight = getBalanceHeight(startingNode.rightChild, canBeBalanced);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      canBeBalanced.setValue(false);
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
