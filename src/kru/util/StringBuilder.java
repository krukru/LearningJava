package kru.util;

import java.io.IOException;
import java.util.Arrays;

public class StringBuilder implements CharSequence, Appendable {

  private static final int INITIAL_CAPACITY = 32;
  private static final int RESIZE_FACTOR = 2;
  private char[] data;
  private int index = 0;

  public StringBuilder() {
    this(INITIAL_CAPACITY);
  }

  public StringBuilder(int initialCapacity) {
    initData(initialCapacity);
  }

  public StringBuilder(String initialString) {
    initData(initialString);
  }

  private void initData(int capacity) {
    this.data = new char[capacity];
  }

  private void initData(String string) {
    int capacity = string.length() + INITIAL_CAPACITY;
    this.data = Arrays.copyOf(string.toCharArray(), capacity);
    this.index = string.length();
  }

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    append(csq, 0, csq.length());
    return this;
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    internalValidate(csq, start, end);
    for (int i = start; i < end; i++) {
      internalAppend(csq.charAt(i));
    }
    return this;
  }

  private void internalValidate(CharSequence csq, int start, int end) {
    if (start < 0 || start > end || end > csq.length()) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public Appendable append(char c) throws IOException {
    internalAppend(c);
    return this;
  }

  private void internalAppend(char c) {
    data[index++] = c;
    if (needResize()) {
      resize();
    }
  }

  private boolean needResize() {
    return index == data.length;
  }

  private void resize() {
    this.data = Arrays.copyOf(data, data.length * RESIZE_FACTOR);
  }

  @Override
  public int length() {
    return index;
  }

  @Override
  public char charAt(int index) {
    if (index < 0 || index >= length()) {
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    if (start < 0 || end > length() || start > end) {
      throw new IndexOutOfBoundsException();
    }
    return new String(data, start, end - start);
  }

  @Override
  public String toString() {
    return new String(data, 0, length());
  }
}
