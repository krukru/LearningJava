package kru.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixQueryTest {

  @Test
  public void testSum() throws Exception {
    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    MatrixQuery matrixQuery = new MatrixQuery(matrix);
    assertEquals(45, matrixQuery.sum(0, 0, 2, 2));
    assertEquals(16, matrixQuery.sum(1, 0, 2, 1));
  }
}