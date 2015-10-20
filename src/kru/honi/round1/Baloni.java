package kru.honi.round1;

import kru.collections.ArrayList;

public class Baloni {

  private final static int MAX_HEIGHT = 1000000;

  public int solve(ArrayList<Integer> ballons) {
    int result = 0;
    int[] lookup = new int[MAX_HEIGHT + 5]; //+5 for good measure
    for (int i = 0; i < ballons.size(); i++) {
      int ballonHeight = ballons.get(i);
      if (lookup[ballonHeight + 1] == 0) {
        /* we're the first ballon to be popped at this height. We're starting a new series */
        result += 1;
        lookup[ballonHeight] += 1;
      } else {
        /* we're just continue along a path */
        lookup[ballonHeight + 1] -= 1;
        lookup[ballonHeight] += 1;
      }
    }
    return result;
  }

}
