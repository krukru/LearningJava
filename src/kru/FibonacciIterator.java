package kru;

import kru.exception.runtimexception.NotImplementedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {

  private int currentNumber = 1;
  private int nextNumber = 1;
  private int maxIndex;
  private int currentIndex;

  public FibonacciIterator() {
    this(Integer.MAX_VALUE);
  }

  public FibonacciIterator(int expectedNumberOfElements) {
    if (expectedNumberOfElements <= 0) {
      throw new IndexOutOfBoundsException();
    }
    this.maxIndex = expectedNumberOfElements;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < maxIndex;
  }

  @Override
  public Integer next() {
    if (currentIndex == maxIndex) {
      throw new NoSuchElementException();
    }
    int result = currentNumber;
    this.nextNumber = nextNumber + currentNumber;
    this.currentNumber = nextNumber - currentNumber;
    this.currentIndex += 1;
    return result;
  }

  @Override
  public void remove() {
    throw new NotImplementedException();
  }
}
