package kru.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Queue<E> extends AbstractList<E> implements java.util.Queue<E> {

  private LinkedList<E> dataCollection = new LinkedList<>();

  @Override
  public int size() {
    return dataCollection.size();
  }

  @Override
  public boolean isEmpty() {
    return dataCollection.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return dataCollection.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return dataCollection.iterator();
  }

  @Override
  public Object[] toArray() {
    return dataCollection.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return dataCollection.toArray(a);
  }

  @Override
  public boolean add(E e) {
    return dataCollection.add(e);
  }

  @Override
  public boolean offer(E e) {
    dataCollection.addLast(e);
    return true;
  }

  public boolean enqueue(E element) {
    return this.offer(element);
  }

  public E dequeue() {
    return this.remove();
  }

  @Override
  public E peek() {
    if (dataCollection.isEmpty()) {
      return null;
    }
    return dataCollection.getFirst();
  }

  @Override
  public E element() {
    if (dataCollection.isEmpty()) {
      throw new NoSuchElementException();
    }
    return dataCollection.getFirst();
  }

  @Override
  public E poll() {
    if (dataCollection.isEmpty()) {
      return null;
    }
    E element = dataCollection.getFirst();
    dataCollection.removeFirst();
    return element;
  }

  @Override
  public E remove() {
    if (dataCollection.isEmpty()) {
      throw new NoSuchElementException();
    }
    E element = dataCollection.getFirst();
    dataCollection.removeFirst();
    return element;
  }

  @Override
  public boolean remove(Object o) {
    return dataCollection.remove(o);
  }

  @Override
  public void clear() {
    dataCollection.clear();
  }

  @Override
  public E get(int index) {
    return dataCollection.get(index);
  }

  @Override
  public E set(int index, E element) {
    return dataCollection.set(index, element);
  }

  @Override
  public void add(int index, E element) {
    dataCollection.add(index, element);
  }

  @Override
  public E remove(int index) {
    return dataCollection.remove(index);
  }

  @Override
  public int indexOf(Object o) {
    return dataCollection.indexOf(o);
  }

  @Override
  public int lastIndexOf(Object o) {
    return dataCollection.lastIndexOf(o);
  }

  @Override
  public ListIterator<E> listIterator() {
    return dataCollection.listIterator();
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return dataCollection.listIterator(index);
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return dataCollection.subList(fromIndex, toIndex);
  }
}
