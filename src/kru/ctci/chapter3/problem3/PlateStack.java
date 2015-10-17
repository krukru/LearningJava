package kru.ctci.chapter3.problem3;

import kru.collections.HashMap;
import kru.collections.Stack;

public class PlateStack<E> {

  private static final int MAX_SINGLE_STACK_SIZE = 10;

  private int singleStackSize;
  /*
   * We need a data structure that will allow us quick insert time (amortized O(1)) and quick
   * random access (index retrieval). Since every HashMap Entry would be a Stack of it's own, it
   * is to expect that there won't be too much of resizing to do for the HashMap.
   */
  private HashMap<Integer, Stack<E>> stackCollection = new HashMap<>(256); /* Should be enaugh */

  private int currentIndex = 0;
  private int size = 0;

  public PlateStack() {
    this(MAX_SINGLE_STACK_SIZE);
  }

  public PlateStack(int singleStackSize) {
    this.singleStackSize = singleStackSize;
    Stack<E> initialStack = new Stack<>();
    stackCollection.put(currentIndex, initialStack);
  }

  public boolean push(E element) {
    if (stackCollection.get(currentIndex).size() == MAX_SINGLE_STACK_SIZE) {
      Stack<E> newStack = new Stack<>();
      currentIndex += 1;
      stackCollection.put(currentIndex, newStack);
    }
    size += 1;
    return stackCollection.get(currentIndex).push(element);
  }

  public E pop() {
    E result = stackCollection.get(currentIndex).pop();
    if (stackCollection.get(currentIndex).isEmpty()) {
      stackCollection.remove(currentIndex);
      currentIndex -= 1;
      if (currentIndex == -1) {
        /* In case we cleared up the entire stack, initialize it for the next push */
        currentIndex = 0;
        stackCollection.put(currentIndex, new Stack<E>());
      }
    }
    size -= 1;
    return result;
  }

  public E popAtStack(int index) {
    if (index < 0 || index > stackCollection.size()) {
      throw new IndexOutOfBoundsException();
    }
    size -= 1;
    return stackCollection.get(index).pop();
  }

  public E peek() {
    return stackCollection.get(currentIndex).peek();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

}
