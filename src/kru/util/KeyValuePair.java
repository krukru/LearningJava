package kru.util;

public class KeyValuePair<K, V> {

  private final K key;
  private V value;

  public KeyValuePair(K key) {
    this.key = key;
  }

  public KeyValuePair(K key, V value) {
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

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof KeyValuePair) {
      KeyValuePair secondKeyValuePair = (KeyValuePair) object;
      return (this.key.equals(secondKeyValuePair.key) && this.value.equals(secondKeyValuePair
          .value));
    } else {
      return false;
    }
  }

}
