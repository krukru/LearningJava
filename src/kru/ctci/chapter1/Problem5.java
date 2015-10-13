package kru.ctci.chapter1;

import kru.util.StringBuilder;

public class Problem5 {
  public String simpleCompress(String input) {
    if (input.length() == 0) {
      return input;
    }
    String result;
    StringBuilder sb = new StringBuilder();
    Integer runningTotal = 1;
    char lastCharacter = input.charAt(0);
    for (int i = 1; i < input.length(); i++) {
      char currentCharacter = input.charAt(i);
      if (currentCharacter == lastCharacter) {
        runningTotal += 1;
      } else {
        sb.append(lastCharacter);
        sb.append(runningTotal.toString());
        lastCharacter = currentCharacter;
        runningTotal = 1;
      }
    }
    sb.append(lastCharacter);
    sb.append(runningTotal.toString());
    String compressedString = sb.toString();
    if (compressedString.length() < input.length()) {
      result = compressedString;
    } else {
      result = input;
    }
    return result;
  }
}
