package kru.hackerrank.algorithms.dynamicprogramming;

public class MaximumSubarray {
  public int largestSumContiguousSubarray(int[] array) {
    if (array.length == 0) {
      throw new IllegalArgumentException("Contract violation, you promised this would never " +
          "happen!");
    }

    if (array.length == 1) {
      return array[0];
    }

    int[] bestRuns = new int[array.length];
    bestRuns[0] = array[0];
    int largestSum = array[0];
    int largestSumIndex = 0;

    for (int i = 1; i < array.length; i++) {
      //we either continue our run, or start a new one
      int previousBestRun = bestRuns[i - 1];
      int currentNumber = array[i];
      bestRuns[i] = Math.max(currentNumber, previousBestRun + currentNumber);
      largestSum = Math.max(largestSum, bestRuns[i]);
    }
    return largestSum;
  }
}
