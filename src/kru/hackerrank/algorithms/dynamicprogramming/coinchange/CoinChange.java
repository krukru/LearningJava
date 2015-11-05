package kru.hackerrank.algorithms.dynamicprogramming.coinchange;

import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class CoinChange {

  //not thread safe
  private HashMap<LookupData, Long> lookup;

  public long numberOfCombinations(int[] coins, int requiredChange) {
    if (lookup != null) {
      throw new ConcurrentModificationException();
    }
    this.lookup = new HashMap<>();
    long solution = numberOfCombinations(coins, requiredChange, coins.length);
    lookup = null;
    return solution;
  }

  private long numberOfCombinations(int[] coins, int requiredChange, int numberOfAvailableCoins) {

    if (numberOfAvailableCoins <= 0) {
      return 0; //no coins means we can't return the change
    }

    if (requiredChange < 0) {
      return 0; //this configuration would return too much cash. So we don't count it as a solution
    }

    if (requiredChange == 0) {
      return 1; //great, we returned the change!
    }

    int lastPossibleCoinValue = coins[numberOfAvailableCoins - 1];

    long subProblem1;
    long subProblem2;
    LookupData l1 = new LookupData(requiredChange - lastPossibleCoinValue, numberOfAvailableCoins);
    LookupData l2 = new LookupData(requiredChange, numberOfAvailableCoins - 1);
    if (lookup.containsKey(l1)) {
      subProblem1 = lookup.get(l1);
    } else {
      //we either take the coin and reduce the remaining change and continue with the same number
      // of coins
      subProblem1 = numberOfCombinations(coins, requiredChange - lastPossibleCoinValue,
          numberOfAvailableCoins);
      lookup.put(l1, subProblem1);
    }
    if (lookup.containsKey(l2)) {
      subProblem2 = lookup.get(l2);
    } else {
      //or we don't take it, in which case we reduce the number of available coins by 1
      subProblem2 = numberOfCombinations(coins, requiredChange, numberOfAvailableCoins - 1);
      lookup.put(l2, subProblem2);
    }
    return subProblem1 + subProblem2;
  }

  private class LookupData {
    private Integer requiredChange;
    private Integer numberOfAvailableCoins;

    public LookupData(Integer requiredChange, Integer numberOfAvailableCoins) {
      this.requiredChange = requiredChange;
      this.numberOfAvailableCoins = numberOfAvailableCoins;
    }

    public Integer getRequiredChange() {
      return requiredChange;
    }

    public Integer getNumberOfAvailableCoins() {
      return numberOfAvailableCoins;
    }

    @Override
    public int hashCode() {
      return requiredChange.hashCode() + numberOfAvailableCoins.hashCode();
    }

    @Override
    public boolean equals(Object object) {
      if (object == null) {
        return false;
      }
      if (object == this) {
        return true;
      }
      if (object instanceof LookupData) {
        LookupData secondObject = (LookupData) object;
        return this.requiredChange.equals(secondObject.requiredChange) &&
            this.numberOfAvailableCoins.equals(secondObject.numberOfAvailableCoins);
      } else {
        return false;
      }
    }
  }
}
