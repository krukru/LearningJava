package kru.honi.round1;

import kru.collections.ArrayList;

import java.util.Collections;

public class Akcija {

  private static final int FREE_ITEM_INDEX = 3;

  public long getTotalPrice(ArrayList<Integer> items) {
    long result = 0;
    Collections.sort(items, Collections.reverseOrder());
    for (int i = 0; i < items.size(); i++) {
      if ((i + 1) % FREE_ITEM_INDEX != 0) {
        result += items.get(i);
      }
    }
    return result;
  }
}
