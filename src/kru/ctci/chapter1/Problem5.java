package kru.ctci.chapter1;

import kru.util.Nullable;
import kru.util.StringBuilder;

public class Problem5 {
  public String simpleCompress(String input) {
    //we could immediately know weather to compress or output
    if (input.length() == 0) {
      return input;
    }
    StringBuilder sb = new StringBuilder();
    int runningTotal = 1;
    char lastCharacter = input.charAt(0);
    for (int i = 1; i < input.length(); i++) {
      char currentCharacter = input.charAt(i);
      if (currentCharacter == lastCharacter) {
        runningTotal += 1;
      }
      else {
        sb.append(lastCharacter);
        sb.append(runningTotal);
      }
    }
    //remember to append the last digit
  }
}
