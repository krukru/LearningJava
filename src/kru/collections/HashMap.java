package kru.collections;

import java.lang.reflect.Array;
import java.util.*;

import kru.exception.runtimexception.NotImplementedException;
import kru.util.Tuple;

public class HashMap<K, V> implements Map<K, V> {

  private static final int DEFAULT_INITIAL_CAPACITY = 32;
  private static final double RESIZE_THRESHOLD = 0.8;
  private static final int RESIZE_FACTOR = 2;

  private int initialCapacity;

  private int size = 0;

  private Bucket[] hashtable;

  public HashMap() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public HashMap(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    initHashtable(initialCapacity);
  }

  @SuppressWarnings("unchecked")
  private void initHashtable(int hashtableSize) {
    this.size = 0;
    this.hashtable = (Bucket[]) Array.newInstance(Bucket.class, hashtableSize);
  }

  private int getCurrentCapacity() {
    return this.hashtable.length;
  }

  @Override
  public void clear() {
    initHashtable(this.initialCapacity);
  }

  @Override
  public boolean containsKey(Object key) {
    boolean containsKey;
    Bucket bucket = this.getBucketForKey(key);
    containsKey = bucket != null && bucket.containsKey(key);
    return containsKey;
  }

  @Override
  public boolean containsValue(Object value) {
    /*
     * While the HashMap is very good at getting the keys, getting the value is an expensive
     * operation
     */
    boolean containsValue = false;
    for (Bucket bucket : this.hashtable) {
      if (bucket != null) {
        containsValue = bucket.containsValue(value);
        if (containsValue) {
          break;
        }
      }
    }
    return containsValue;
  }

  public boolean equals(HashMap secondMap) {
    if (this.size() != secondMap.size() || this.getCurrentCapacity() != secondMap.getCurrentCapacity()) {
      return false;
    }
    for (int i = 0; i < this.hashtable.length; i++) {
      Bucket firstBucket = this.hashtable[i];
      Bucket secondBucket = secondMap.hashtable[i];
      if (firstBucket != null && secondBucket != null) {
        boolean areEqual = firstBucket.equals(secondBucket);
        if (areEqual == false) {
          return false;
        }
      }
      else if (firstBucket == null && secondBucket == null) {
        /* still need to check */
      }
      else {
        return false;
      }
    }
    return true;
  }

  @Override
  public Set<Map.Entry<K, V>> entrySet() {
    throw new NotImplementedException("Real sorry bro, maybe next version");
  }

  @Override
  public V get(Object key) {
    V result = null;
    Bucket bucket = this.getBucketForKey(key);
    if (bucket != null) {
      for (Entry entry : bucket) {
        if (entry.getKey().equals(key)) {
          result = entry.getValue();
          break;
        }
      }
    }
    return result;
  }

  @Override
  public boolean isEmpty() {
    return (this.size == 0);
  }

  @Override
  public Set<K> keySet() {
    throw new NotImplementedException("Sorry");
  }

  @Override
  public V put(K key, V value) {
    V oldValue = null;
    if (key == null) {
      throw new IllegalArgumentException("No null keys allowed");
    }
    Entry newEntry = new Entry(key, value);
    int bucketIndex = this.getBucketIndex(key);
    Bucket bucket = this.hashtable[bucketIndex];
    if (bucket == null) {
      Bucket newBucket = new Bucket();
      newBucket.add(newEntry);
      this.hashtable[bucketIndex] = newBucket;
      this.size += 1;
    } else {
      /* Well, we need to check if a value already exists */
      boolean itemReplaced = false;
      for (Entry entry : bucket) {
        if (entry.getKey().equals(key)) {
          oldValue = entry.getValue(); /* contract states we should return the old value */
          entry.setValue(value);
          itemReplaced = true;
          break;
        }
      }
      if (itemReplaced == false) {
        this.size += 1;
        this.hashtable[bucketIndex].add(newEntry);
      }
    }
    if (this.requiresResize()) {
      this.resize();
    }
    return oldValue;
  }

  private void resize() {
    int newCapacity = this.getCurrentCapacity() * this.RESIZE_FACTOR;
    Bucket[] newHashtable = (Bucket[]) Array.newInstance(Bucket.class, newCapacity);
    for (int i = 0; i < this.hashtable.length; i++) {
      newHashtable[i] = this.hashtable[i];
    }
    this.hashtable = newHashtable;
  }

  private boolean requiresResize() {
    return this.size > this.getCurrentCapacity() * this.RESIZE_THRESHOLD;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> map) {
    for (Map.Entry<? extends K, ? extends V> item : map.entrySet()) {
      this.put(item.getKey(), item.getValue());
    }
  }

  @Override
  public V remove(Object key) {
    V result = null;
    int bucketIndex = this.getBucketIndex(key);
    Bucket bucket = this.hashtable[bucketIndex];
    if (bucket != null) {
      Entry removedEntry = bucket.remove(key);
      if (removedEntry != null) {
        this.size -= 1;
        result = removedEntry.getValue();
      }
    }
    return result;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public Collection<V> values() {
    throw new NotImplementedException();
  }

  private int getBucketIndex(Object key) {
    return key.hashCode() % this.getCurrentCapacity();
  }

  private Bucket getBucketForKey(Object key) {
    return this.hashtable[getBucketIndex(key)];
  }

  private class Bucket implements Iterable<Entry> {
    private LinkedList<Entry> entries = new LinkedList<Entry>();

    public void add(K key, V value) {
      Entry newEntry = new Entry(key, value);
      this.add(newEntry);
    }

    public void add(Entry entry) {
      this.entries.add(entry);
    }

    public Entry remove(Object key) {
      Entry removedEntry = null;
      int index = 0;
      for (Entry entry : this.entries) {
        if (entry.getKey().equals(key)) {
          removedEntry = entry;
          this.entries.remove(index);
          break;
        }
        index += 1;
      }
      return removedEntry;
    }

    public boolean equals(Bucket secondBucket) {
      if (this.size() != secondBucket.size()) {
        return false;
      }
      ListIterator<Entry> firstBucketIterator = this.entries.listIterator();
      ListIterator<Entry> secondBucketIterator = secondBucket.entries.listIterator();
      while (firstBucketIterator.hasNext()) {
        Entry firstEntry = firstBucketIterator.next();
        Entry secondEntry = secondBucketIterator.next();
        if (firstEntry.equals(secondEntry) == false) {
          return false;
        }
      }
      return true;
    }

    public int size() {
      return this.entries.size();
    }

    public boolean containsValue(Object value) {
      boolean containsValue = false;
      for (Entry entry : entries) {
        if (entry.getValue().equals(value)) {
          containsValue = true;
          break;
        }
      }
      return containsValue;
    }

    public boolean containsKey(Object key) {
      boolean containsKey = false;
      for (Entry entry : entries) {
        if (entry.getKey().equals(key)) {
          containsKey = true;
          break;
        }
      }
      return containsKey;
    }

    @Override
    public Iterator<Entry> iterator() {
      return this.entries.iterator();
    }
  }

  private class Entry implements Map.Entry<K, V> {

    private Tuple<K, V> tuple;

    public Entry(K key, V value) {
      this.tuple = new Tuple<K, V>(key, value);
    }

    @Override
    public K getKey() {
      return this.tuple.getKey();
    }

    @Override
    public V getValue() {
      return this.tuple.getValue();
    }

    @Override
    public V setValue(V value) {
      /* Contract says we should return the old value */
      V oldValue = this.tuple.getValue();
      this.tuple.setValue(value);
      return oldValue;
    }

    public boolean equals(Entry secondEntry) {
      return (this.tuple.getKey() == secondEntry.tuple.getKey()) && (this.tuple.getValue() == secondEntry.tuple.getValue());
    }
  }
}
