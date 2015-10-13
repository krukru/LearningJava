package kru.util;

public class Tuple<K, V> {

  private final K item1;
  private final V item2;

  public Tuple(K item1, V item2) {
    this.item1 = item1;
    this.item2 = item2;
  }

  public K getItem1() {
    return this.item1;
  }

  public V getItem2() {
    return this.item2;
  }

  public static <K, V> Tuple<K, V> create(K item1, V item2) {
    return new Tuple<>(item1, item2);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object instanceof Tuple) {
      Tuple secondKeyValuePair = (Tuple) object;
      return (this.item1.equals(secondKeyValuePair.item1) && this.item2.equals(secondKeyValuePair.item2));
    } else {
      return false;
    }
  }

}
