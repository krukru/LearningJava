package kru.hackerrank.algorithms.dynamicprogramming.coinchange;

import java.util.Scanner;

public class Solution {

  private static CoinChange solution = new CoinChange();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int requiredChange = in.nextInt();
    int numberOfCoins = in.nextInt();
    int[] coins = new int[numberOfCoins];
    for (int i = 0; i < numberOfCoins; i++) {
      coins[i] = in.nextInt();
    }
    System.out.println(solution.numberOfCombinations(coins, requiredChange));
  }
}

