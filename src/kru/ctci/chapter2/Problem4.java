package kru.ctci.chapter2;

import kru.collections.LinkedList;

public class Problem4 {
  public <E extends Comparable<E>> LinkedList<E> partitionList(LinkedList<E> list, E
      partitionElement) {
    LinkedList<E> partitionedList = new LinkedList<>();
    for (E element : list) {
      if (element.compareTo(partitionElement) >= 0) {
        /* element is greater or equal than partitionElement */
        partitionedList.addLast(element);
      } else {
        partitionedList.addFirst(element);
      }
    }
    return partitionedList;
  }
}
