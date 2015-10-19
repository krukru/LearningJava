package kru.ctci.chapter4;

import kru.collections.ArrayList;
import kru.trees.binarytree.BinarySearchTree;

import java.util.List;

public class Problem3 {

  public BinarySearchTree<Integer> fillBinarySearchTree(ArrayList<Integer> sortedList) {
    BinarySearchTree<Integer> result = new BinarySearchTree<>();
    fillBinarySearchTree(result, sortedList);
    return result;
  }

  private void fillBinarySearchTree(BinarySearchTree<Integer> tree, List<Integer> sortedList) {
    if (sortedList.isEmpty() == false) {
      int middleIndex = sortedList.size() / 2;
      int middleElement = sortedList.get(middleIndex);
      tree.add(middleElement);
      if (sortedList.size() > 1) {
        fillBinarySearchTree(tree, sortedList.subList(0, middleIndex));
        fillBinarySearchTree(tree, sortedList.subList(middleIndex, sortedList.size()));
      }
    }
  }
}
