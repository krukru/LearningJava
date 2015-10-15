package kru.ctci.chapter1.testing;

import org.junit.Test;

import kru.ctci.chapter1.Problem6;

import static org.junit.Assert.assertArrayEquals;

public class Problem6Test {

  Problem6 p6 = new Problem6();

  @Test
  public void testRotate1x1() {
    int[][] matrix = {{0}};
    int[][] expectedMatrix = {{0}};
    p6.rotateInPlace(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testRotate2x2_Example1() {
    int[][] matrix = {{1, 1}, {1, 1}};
    int[][] expectedMatrix = {{1, 1}, {1, 1}};
    p6.rotateInPlace(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testRotate2x2_Example2() {
    int[][] matrix = {{0, 1}, {2, 3}};
    int[][] expectedMatrix = {{2, 0}, {3, 1}};
    p6.rotateInPlace(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testRotate5x5() {
    int[][] matrix = new int[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        matrix[i][j] = i * 5 + j;
      }
    }
    p6.rotateInPlace(matrix);
    int[][] expectedMatrix = new int[5][5];
    /* Well this is obviously a horrible test
     * because who knows if this produces the correct expectedMatrix.
     * However, it's a simple example - so trust me with this one. */
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        expectedMatrix[j][4 - i] = i * 5 + j;
      }
    }
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void evaluationTest1() {
    int[][] inputMatrix = {{1, 2}, {3, 4}};
    int[][] expectedMatrix = {{3, 1}, {4, 2}};
    p6.rotateInPlace(inputMatrix);
    assertArrayEquals(expectedMatrix, inputMatrix);
  }

  @Test
  public void evaluationTest2() {
    int[][] inputMatrix = {{1}};
    int[][] expectedMatrix = {{1}};
    p6.rotateInPlace(inputMatrix);
    assertArrayEquals(expectedMatrix, inputMatrix);
  }
}