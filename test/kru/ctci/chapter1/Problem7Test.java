package kru.ctci.chapter1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Problem7Test {

  private Problem7 p7 = new Problem7();

  @Test
  public void testBasic1() {
    int[][] matrix = {{0}};
    int[][] expectedMatrix = {{0}};
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testBasic2_NothingToReplace() {
    int[][] matrix = {{1, 2}, {3, 4}};
    int[][] expectedMatrix = {{1, 2}, {3, 4}};
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testBasic3_PartialReplace() {
    int[][] matrix = {{1, 0, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] expectedMatrix = {{0, 0, 0}, {4, 0, 6}, {7, 0, 9}};
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testBasic4_PartialReplace() {
    int[][] matrix = {{0, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int[][] expectedMatrix = {{0, 0, 0}, {0, 5, 0}, {0, 0, 0}};
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testBasic4_FullReplace() {
    int[][] matrix = {{0, 2, 3}, {4, 0, 6}, {7, 8, 0}};
    int[][] expectedMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void testLargeMatrix() {
    /* Again a test with too much logic in it :-( */
    int[][] matrix = new int[1000][1000];
    int[][] expectedMatrix = new int[1000][1000];
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        if (i == 0 && j == 0 || i == 999 && j == 999) {
          matrix[i][j] = 0;
        } else {
          matrix[i][j] = 1;
        }
      }
    }
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        if (i == 0 || j == 0 || i == 999 || j == 999) {
          expectedMatrix[i][j] = 0;
        } else {
          expectedMatrix[i][j] = 1;
        }
      }
    }
    p7.setToZeroRowsAndColumnsThatContainZero(matrix);
    assertArrayEquals(expectedMatrix, matrix);
  }

  @Test
  public void evaluationTest1() {
    int[][] inputMatrix = {{1, 0}, {0, 4}};
    int[][] expectedMatrix = {{0, 0}, {0, 0}};
    p7.setToZeroRowsAndColumnsThatContainZero(inputMatrix);
    assertArrayEquals(expectedMatrix, inputMatrix);
  }

  @Test
  public void evaluationTest2() {
    int[][] inputMatrix = new int[5][5];
    int[][] expectedMatrix = new int[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        inputMatrix[i][j] = (i == 4 - j) ? 1 : 0;
        expectedMatrix[i][j] = 0;
      }
    }
    p7.setToZeroRowsAndColumnsThatContainZero(inputMatrix);
    assertArrayEquals(expectedMatrix, inputMatrix);
  }

  @Test
  public void evaluationTest3() {
    int[][] inputMatrix = {{1, 2, 0, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 0}};
    int[][] expectedMatrix = new int[4][4];
    expectedMatrix[1][0] = 5;
    p7.setToZeroRowsAndColumnsThatContainZero(inputMatrix);
    assertArrayEquals(expectedMatrix, inputMatrix);
  }
}
