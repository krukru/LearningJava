package kru.util;

public class Nullable<T> {
  private T value = null;

  public Nullable() {
  }

  public Nullable(T value) {
    this.value = value;
  }

  public boolean hasValue() {
    return value != null;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    if (value == null) {
      throw new IllegalStateException();
    }
    return value;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || value == null) {
      return object == value;
    }
    if (object instanceof Nullable) {
      Nullable secondNullable = (Nullable) object;
      return this.hasValue() == secondNullable.hasValue() && (this.value == null || this.value
          .equals(secondNullable.value));
    } else {
      return value.getClass().equals(object.getClass()) && value.equals(object);
    }
  }
}
