package kru.collections;

import kru.exception.runtimexception.NotImplementedException;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayList<E> extends AbstractList<E> {

  private final static int INITIAL_CAPACITY = 32;
  private final static double RESIZE_THRESHOLD = 0.8;
  private final static int RESIZE_FACTOR = 2;

  private E[] array;

  private int size = 0;

  public ArrayList() {
    initArray(INITIAL_CAPACITY);
  }

  private void initArray(int initialCapacity) {
    this.size = 0;
    this.array = (E[]) new Object[initialCapacity];
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean contains(Object object) {
    for (E element : this) {
      if (element.equals(object)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(this.array, this.size);
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new NotImplementedException("Nope");
  }

  @Override
  public boolean add(E element) {
    this.add(this.size, element);
    return true;
  }

  @Override
  public void add(int index, E element) {
    internalInsert(index, element);
    this.size += 1;
  }

  private void internalInsert(int index, E element) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
    shiftArrayBeforeInsert(index);
    this.array[index] = element;
  }

  private void shiftArrayBeforeInsert(int index) {
    int shiftingIndex = this.size - 1;
    while (index <= shiftingIndex) {
      this.array[shiftingIndex + 1] = this.array[shiftingIndex];
      shiftingIndex -= 1;
    }
  }

  @Override
  public boolean remove(Object object) {
    int index = indexOf(object);
    if (index != -1) {
      internalRemove(index);
      this.size -= 1;
      return true;
    }
    return false;
  }

  @Override
  public E remove(int index) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
    E element = this.array[index];
    internalRemove(index);
    this.size -= 1;
    return element;
  }

  private void internalRemove(int index) {
    for (int i = index; i < this.size - 1; i++) {
      this.array[i] = this.array[i + 1];
    }
  }

  @Override
  public void clear() {
    initArray(INITIAL_CAPACITY);
  }

  @Override
  public E get(int index) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
    return this.array[index];
  }

  @Override
  public E set(int index, E element) {
    if (index > size) {
      throw new IndexOutOfBoundsException();
    }
    E oldValue = this.array[index];
    this.array[index] = element;
    return oldValue;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return null;
  }
}
