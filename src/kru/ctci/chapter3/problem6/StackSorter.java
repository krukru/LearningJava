package kru.ctci.chapter3.problem6;

import kru.collections.Stack;

public class StackSorter {
  public <E extends Comparable<E>> void sort(Stack<E> stack) {
    if (stack.size() > 1) {
      Stack<E> helperStack = new Stack<>();
      int stackSize = stack.size();
      for (int numberOfSortedElements = 0; numberOfSortedElements < stackSize;
           numberOfSortedElements++) {
        E minimalElement = stack.peek();
        while (stack.size() > numberOfSortedElements) {
          E poppedElement = stack.pop();
          helperStack.push(poppedElement);
          if (poppedElement.compareTo(minimalElement) > 0) {
            minimalElement = poppedElement;
          }
        }
        stack.push(minimalElement);
        while (helperStack.isEmpty() == false) {
          E element = helperStack.pop();
          if (element != minimalElement) {
            stack.push(element);
          }
        }
      }
    }
  }
}
