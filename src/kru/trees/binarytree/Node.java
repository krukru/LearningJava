package kru.trees.binarytree;

public class Node<E> {
  public E data;
  public Node<E> leftChild;
  public Node<E> rightChild;

  public Node() {}

  public Node(E element) {
    this.data = element;
  }
}
