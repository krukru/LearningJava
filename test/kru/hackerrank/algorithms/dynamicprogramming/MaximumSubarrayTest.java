package kru.hackerrank.algorithms.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumSubarrayTest {

  MaximumSubarray solution = new MaximumSubarray();

  @Test
  public void testLargestSumContiguousSubarray_case1() throws Exception {
    int[] array = new int[]{2, -1, 2, 3, 4, -5};
    assertEquals(10, solution.largestSumContiguousSubarray(array));
  }

  @Test
  public void testLargestSumContiguousSubarray_case2() throws Exception {
    int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    assertEquals(6, solution.largestSumContiguousSubarray(array));
  }
}