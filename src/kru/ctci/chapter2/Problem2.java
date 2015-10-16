package kru.ctci.chapter2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import kru.collections.ArrayList;
import kru.collections.LinkedList;

public class Problem2 {
  public <E> E findKthLastElement(LinkedList<E> list, int k) {
    /* The problem constraint says that we should treat the list as
     * a singly linked list. This means we cannot start
     * from the end of the list and work our way to the beginning */
    if (k <= 0 || k > list.size()) {
      throw new IndexOutOfBoundsException();
    }
    Iterator<E> it = list.iterator();
    int listSize = list.size();
    for (int i = 0; i < list.size(); i++) {
      E element = it.next();
      if (i == listSize - k) {
        return element;
      }
    }
    throw new RuntimeException("This can never happen");
  }

}
