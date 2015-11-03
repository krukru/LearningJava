package kru.hackerrank.algorithms.dynamicprogramming.maximumsubarray;

import java.util.Scanner;

public class Solution {

  private static MaximumSubarray solution = new MaximumSubarray();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfTestCases = in.nextInt();
    for (int i = 0; i < numberOfTestCases; i++) {
      int arraySize = in.nextInt();
      int[] array = new int[arraySize];
      for (int j = 0; j < arraySize; j++) {
        array[j] = in.nextInt();
      }
      int largestContiguousSum = solution.largestSumContiguousSubarray(array);
      int largestSum = solution.largestSum(array);
      System.out.println(String.format("%s %s", largestContiguousSum, largestSum));
    }

  }


}

