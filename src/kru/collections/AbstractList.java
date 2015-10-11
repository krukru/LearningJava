package kru.collections;

import java.util.Collection;
import java.util.List;

/**
 * Provides basic functionality for classes implmenting the List interface
 * @param <E>
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
}
