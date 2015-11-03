package kru.hackerrank.algorithms.dynamicprogramming.maximumsubarray;

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

  @Test
  public void testLargestSumContiguousSubarray_hackerrank() throws Exception {
    int[] array1 = new int[]{1};
    int[] array2 = new int[]{-1,-2,-3,-4,-5,-6};
    int[] array3 = new int[]{1,-2};
    int[] array4 = new int[]{1,2,3};
    int[] array5 = new int[]{-10};
    int[] array6 = new int[]{1, -1, -1, -1, -1, 5};
    assertEquals(1, solution.largestSumContiguousSubarray(array1));
    assertEquals(1, solution.largestSum(array1));
    assertEquals(-1, solution.largestSumContiguousSubarray(array2));
    assertEquals(-1, solution.largestSum(array2));
    assertEquals(1, solution.largestSumContiguousSubarray(array3));
    assertEquals(1, solution.largestSum(array3));
    assertEquals(6, solution.largestSumContiguousSubarray(array4));
    assertEquals(6, solution.largestSum(array4));
    assertEquals(-10, solution.largestSumContiguousSubarray(array5));
    assertEquals(-10, solution.largestSum(array5));
    assertEquals(5, solution.largestSumContiguousSubarray(array6));
    assertEquals(6, solution.largestSum(array6));
  }
}