package kru.ctci.chapter2;

import java.util.ListIterator;

import kru.collections.LinkedList;

public class Problem7 {
  public boolean isPalindrome(LinkedList<Character> list) {
    if (list.size() == 0) {
      return true;
    }
    ListIterator<Character> headIterator = list.listIterator();
    ListIterator<Character> tailIterator = list.tailListIterator();
    while (headIterator.hasNext() && tailIterator.hasPrevious()) {
      Character elementA = headIterator.next();
      Character elementB = tailIterator.previous();
      if (Character.isLetterOrDigit(elementA) == false) {
        tailIterator.next(); //reverse the iterator, it will be fixed in the next iteration
        continue;
      }
      if (Character.isLetterOrDigit(elementB) == false) {
        headIterator.previous(); //reverse the iterator, it will be fixed in the next iteration
        continue;
      }
      if (elementA.equals(elementB) == false) {
        return false;
      }
    }
    return true;
  }
}
