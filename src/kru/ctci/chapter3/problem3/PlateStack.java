package kru.ctci.chapter3.problem3;

import kru.collections.LinkedList;
import kru.collections.Stack;

public class PlateStack<E> {

  private static final int MAX_SINGLE_STACK_SIZE = 5;

  private int singleStackSize;
  private LinkedList<Stack<E>> stackCollection = new LinkedList<>();


  public PlateStack() {
    this(MAX_SINGLE_STACK_SIZE);
  }

  public PlateStack(int singleStackSize) {
    this.singleStackSize = singleStackSize;
    Stack<E> initialStack = new Stack<>();
    stackCollection.add(initialStack);
  }

  public boolean push(E element) {
    if (stackCollection.getLast().size() == MAX_SINGLE_STACK_SIZE) {
      Stack<E> newStack = new Stack<>();
      stackCollection.addLast(newStack);
    }
    return stackCollection.getLast().push(element);
  }

  public E pop() {
    E result = stackCollection.getLast().pop();
    if (stackCollection.getLast().isEmpty()) {
      stackCollection.removeLast();
      if (stackCollection.isEmpty()) {
        /* In case we cleared up the entire stack, initialize it for the next push */
        stackCollection.addFirst(new Stack<E>());
      }
    }
    return result;
  }

  public E peek() {
    return stackCollection.getLast().peek();
  }

  public int size() {
    return MAX_SINGLE_STACK_SIZE * (stackCollection.size() - 1) + stackCollection.getLast().size();
  }

}
