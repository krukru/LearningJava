package kru.util;

public class Wrappable<E> {
  private E data;

  public Wrappable() {}

  public Wrappable(E data) {
    this.data = data;
  }

  public E getValue() {
    return data;
  }

  public void setValue(E data) {
    this.data = data;
  }
}
