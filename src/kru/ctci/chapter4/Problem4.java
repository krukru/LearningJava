package kru.ctci.chapter4;

import kru.collections.HashMap;
import kru.collections.LinkedList;
import kru.trees.binarytree.BinaryTree;
import kru.trees.binarytree.Node;

public class Problem4 {

  public <E> HashMap<Integer, LinkedList<E>> toLinkedListMap(BinaryTree<E> tree) {
    HashMap<Integer, LinkedList<E>> result = new HashMap<>();
    if (tree.root == null) {
      return result;
    }

    LinkedList<E> firstLayer = new LinkedList<>();
    firstLayer.addFirst(tree.root.data);
    result.put(1, firstLayer);

    populateHashMap(result, tree.root.leftChild, 2);
    populateHashMap(result, tree.root.rightChild, 2);

    return result;
  }

  private <E> void populateHashMap(HashMap<Integer, LinkedList<E>> result, Node<E> node, int
      height) {
    if (node == null) {
      return;
    }
    if (result.containsKey(height) == false) {
      result.put(height, new LinkedList<E>());
    }
    result.get(height).addLast(node.data);
    populateHashMap(result, node.leftChild, height + 1);
    populateHashMap(result, node.rightChild, height + 1);
  }
}
