package kru.ctci.chapter3.problem1;

import java.util.NoSuchElementException;

public class MultiQueueInstance<E> {

  private FixedMultiQueue<E> container;
  int startIndex;
  int endIndex;
  int headIndex;
  int tailIndex;

  public MultiQueueInstance(FixedMultiQueue<E> container, int startIndex, int endIndex) {
    this.container = container;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.headIndex = startIndex;
    this.tailIndex = startIndex;
  }

  public void enqueue(E element) {
    container.data[tailIndex] = element;
    tailIndex += 1;
    if (needToResize()) {
      container.resize();
    }
  }

  private boolean needToResize() {
    return tailIndex > endIndex;
  }

  public E dequeue() {
    E result = peek();
    this.headIndex += 1;
    return result;
  }

  public E peek() {
    if (tailIndex == startIndex) {
      throw new NoSuchElementException("No elements in queue");
    }
    return (container.data[headIndex]);
  }
}
