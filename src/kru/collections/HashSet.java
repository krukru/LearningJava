package kru.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import kru.exception.runtimexception.NotImplementedException;

public class HashSet<E> implements Set<E> {

  private HashMap<E, Object> hashmap = new HashMap<>();

  @Override
  public int size() {
    return hashmap.size();
  }

  @Override
  public boolean isEmpty() {
    return hashmap.isEmpty();
  }

  @Override
  public boolean contains(Object object) {
    return hashmap.containsKey(object);
  }

  @Override
  public Iterator<E> iterator() {
    return hashmap.keySet().iterator();
  }

  @Override
  public Object[] toArray() {
    return hashmap.keySet().toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return hashmap.keySet().toArray(a);
  }

  @Override
  public boolean add(E element) {
    if (hashmap.containsKey(element)) {
      return false;
    } else {
      hashmap.put(element, null);
      return true;
    }
  }

  @Override
  public boolean remove(Object object) {
    if (hashmap.containsKey(object)) {
      return false;
    } else {
      hashmap.remove(object);
      return true;
    }
  }

  @Override
  public boolean containsAll(Collection<?> collection) {
    for (Object object : collection) {
      if (hashmap.containsKey(object) == false) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends E> collection) {
    boolean collectionChanged = false;
    for (E element : collection) {
      collectionChanged = this.add(element) || collectionChanged;
    }
    return collectionChanged;
  }

  @Override
  public boolean retainAll(Collection<?> collection) {
    boolean collectionChanged = false;
    for (Object object : collection) {
      if (contains(object) == false) {
        remove(object);
        collectionChanged = true;
      }
    }
    return collectionChanged;
  }

  @Override
  public boolean removeAll(Collection<?> collection) {
    boolean collectionChanged = false;
    for (Object object : collection) {
      collectionChanged = remove(object) || collectionChanged;
    }
    return collectionChanged;
  }

  @Override
  public void clear() {
    this.hashmap.clear();
  }
}
