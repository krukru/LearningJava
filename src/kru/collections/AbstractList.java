package kru.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Provides basic functionality for classes implementing the List interface
 */
public abstract class AbstractList<E> implements List<E> {

  @Override
  public boolean containsAll(Collection<?> collection) {
    for (Object element : collection) {
      if (contains(element) == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {
    return addAll(0, collection);
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> collection) {
    int offset = 0;
    for (E element : collection) {
      this.add(index + offset, element);
      offset += 1;
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    boolean collectionUpdated = false;
    for (Object element : collection) {
      boolean elementRemoved = remove(element);
      collectionUpdated = elementRemoved || collectionUpdated;
    }
    return collectionUpdated;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    boolean collectionUpdated = false;
    for (Object element : collection) {
      if (contains(element) == false) {
        boolean elementRemoved = remove(element);
        collectionUpdated = elementRemoved || collectionUpdated;
      }
    }
    return collectionUpdated;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof List == false) {
      return false;
    }
    List<E> secondList = (List<E>) object;
    if (this.size() != secondList.size()) {
      return false;
    }
    Iterator<E> firstIterator = this.iterator();
    Iterator<E> secondIterator = secondList.iterator();
    while (firstIterator.hasNext()) {
      E firstElement = firstIterator.next();
      E secondElement = secondIterator.next();
      if (firstElement.equals(secondElement) == false) {
        return false;
      }
    }
    return true;
  }
}
