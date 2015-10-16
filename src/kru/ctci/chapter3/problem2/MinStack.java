package kru.ctci.chapter3.problem2;

import kru.collections.Stack;


/**
 * One solution here is to use an extra stack for internal tracking of min values
 * Another proposed solution is to encapsulate the data in a MinTrackingNode that tracks
 * the current min state.
 *
 * I like the first solution better
 */
public class MinStack<E extends Comparable<E>> extends Stack<E> {

  private Stack<E> minTrackingStack = new Stack<>();

  @Override
  public boolean push(E element) {
    if (minTrackingStack.isEmpty() || element.compareTo(minTrackingStack.peek()) < 0){
      minTrackingStack.push(element);
    }
    return super.push(element);
  }

  @Override
  public E pop() {
    E result = super.pop();
    if (result == minTrackingStack.peek()) {
      /* no need for equals, same it's the same reference */
      minTrackingStack.pop();
    }
    return result;
  }

  public E getMin() {
    return minTrackingStack.peek();
  }
}
