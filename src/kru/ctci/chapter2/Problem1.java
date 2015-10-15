package kru.ctci.chapter2;

import java.util.Iterator;

import kru.collections.HashSet;
import kru.collections.LinkedList;

public class Problem1 {
  public <E> void removeDuplicates(LinkedList<E> list) {
    HashSet<E> lookup = new HashSet<>();
    for (Iterator<E> it = list.iterator(); it.hasNext(); /* nop */) {
      E element = it.next();
      if (lookup.contains(element)) {
        it.remove();
      }
      else {
        lookup.add(element);
      }
    }
  }
}
