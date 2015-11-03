package kru.math;

public class ArrayQuery {

  private int[] sumCache;
  private int[] array;

  public ArrayQuery(int[] array) {
    if (array.length == 0) {
      throw new IllegalArgumentException();
    }
    this.array = array;
    this.sumCache = new int[array.length + 1];
    recalculateCache(0);
  }

  public int sum(int startIndex) {
    return sum(startIndex, array.length);
  }

  public int sum(int startIndex, int endIndex) {
    if (endIndex < startIndex || endIndex > array.length) {
      throw new IllegalArgumentException();
    }
    if (endIndex == startIndex) {
      return 0;
    }
    return sumCache[endIndex] - sumCache[startIndex];
  }

  public void updateValue(int newValue, int index) {
    if (index < 0 || index >= array.length) {
      throw new IndexOutOfBoundsException();
    }
    if (array[index] != newValue) {
      array[index] = newValue;
      recalculateCache(index);
    }
  }

  private void recalculateCache(int index) {
    if (index < 0 || index >= array.length) {
      throw new IndexOutOfBoundsException();
    }
    for (int i = index + 1; i <= array.length; i++) {
      sumCache[i] = array[i - 1] + sumCache[i - 1];
    }
  }
}
