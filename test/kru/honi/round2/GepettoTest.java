package kru.honi.round2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Random;

public class GepettoTest {

  private Gepetto g = new Gepetto();

  @Test
  public void testNumberOfPossibleCombinations() throws Exception {
    int[] mask = new int[]{1 << 17 | 1 << 10, 1 << 3 | 1 << 15, 1 << 14 | 1 << 13};
    Random rand = new Random();
    int n = 20;
    int max = 1 << n;
    int expectedSum = 0;


    BitSuffixTree bst = new BitSuffixTree();
    for (int m : mask) {
      bst.addNumber(m);
    }

    for (int i = 0; i < max; i++) {
      boolean count = true;
      for (int m : mask) {
        if ((i & m) == m) {
          count = false;
          break;
        }
      }
      expectedSum += (count) ? 1 : 0;
      if (count == bst.hasMatch(i)) {
        System.out.println(i);
        fail();
      }
    }
    assertEquals(expectedSum, Gepetto.numberOfPossibleCombinations(n, bst));
  }
}