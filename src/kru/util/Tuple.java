package kru.util;

public class Tuple<K, V> {

  private final K key;
  private V value;

  public Tuple(K key) {
    this.key = key;
  }

  public Tuple(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return this.key;
  }

  public V getValue() {
    return this.value;
  }

  public void setValue(V value) {
    this.value = value;
  }

}
