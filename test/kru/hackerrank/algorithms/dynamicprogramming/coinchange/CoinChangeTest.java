package kru.hackerrank.algorithms.dynamicprogramming.coinchange;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoinChangeTest {

  private CoinChange cc = new CoinChange();

  @Test
  public void testNumberOfCombinations_case1() throws Exception {
    int[] coins = new int[]{1, 2, 3};
    int change = 4;
    assertEquals(4, cc.numberOfCombinations(coins, change));
  }

  @Test
  public void testNumberOfCombinations_case2() throws Exception {
    int[] coins = new int[]{1, 2, 3};
    int change = 5;
    assertEquals(5, cc.numberOfCombinations(coins, change));
  }

  @Test
  public void testNumberOfCombinations_case3() throws Exception {
    int[] coins = new int[]{2, 3, 5, 6};
    int change = 10;
    assertEquals(5, cc.numberOfCombinations(coins, change));
  }
}