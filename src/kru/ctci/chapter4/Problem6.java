package kru.ctci.chapter4;

import kru.collections.ArrayList;
import kru.trees.binarytree.BinarySearchTree;

public class Problem6 {
  public <E extends Comparable<E>> ArrayList<E> iterateTree(BinarySearchTree<E> tree) {
    ArrayList<E> result = new ArrayList<>(tree.size() + 10);
    for (E element : tree) {
      result.add(element);
    }
    return result;
  }
}
