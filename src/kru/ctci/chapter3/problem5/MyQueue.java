package kru.ctci.chapter3.problem5;

import kru.collections.Stack;

public class MyQueue<E> {
  private Stack<E> enqueueStack = new Stack<>();
  private Stack<E> dequeueStack = new Stack<>();

  public void enqueue(E element) {
    enqueueStack.push(element);
  }

  public E dequeue() {
    if (dequeueStack.isEmpty()) {
      swapStacks();
    }
    return dequeueStack.pop();
  }

  private void swapStacks() {
    while (enqueueStack.isEmpty() == false) {
      E element = enqueueStack.pop();
      dequeueStack.push(element);
    }
  }

  public E peek() {
    if (dequeueStack.isEmpty()) {
      swapStacks();
    }
    return dequeueStack.peek();
  }

  public int size() {
    return enqueueStack.size() + dequeueStack.size();
  }

  public boolean isEmpty() {
    return enqueueStack.isEmpty() && dequeueStack.isEmpty();
  }
}
