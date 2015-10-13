package kru.ctci.chapter1;

import kru.collections.HashSet;

public class Problem1 {
  public boolean areAllCharactersUnique(String input) {
    HashSet<Character> lookup = new HashSet<>();
    for (char c : input.toCharArray()) {
      if (lookup.contains(c)) {
        return false;
      }
      else {
        lookup.add(c);
      }
    }
    return true;
  }
}
