package kru.trees.binarytree;

public class Node<E> {
  public E data;
  public Node<E> parent;
  public Node<E> leftChild;
  public Node<E> rightChild;

  public Node() {}

  public Node(E data) {
    this.data = data;
  }

  public Node(Node<E> parent, E data) {
    this.parent = parent;
    this.data = data;
  }
}
