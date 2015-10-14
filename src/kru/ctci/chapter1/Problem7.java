package kru.ctci.chapter1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem7 {

  private static final int ERASURE_NUMBER = 0;

  public void setToZeroRowsAndColumnsThatContainZero(int[][] matrix) {
    Set<Integer> rows = new LinkedHashSet<>();
    Set<Integer> columns = new LinkedHashSet<>();
    int height = matrix.length;
    int width = matrix[0].length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (matrix[i][j] == ERASURE_NUMBER) {
          rows.add(i);
          columns.add(j);
        }
      }
    }
    for (Integer row : rows) {
      eraseRow(matrix, row);
    }
    for (Integer column : columns) {
      eraseColumn(matrix, column);
    }
  }

  private void eraseColumn(int[][] matrix, Integer column) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][column] = 0;
    }
  }

  private void eraseRow(int[][] matrix, Integer row) {
    for (int j = 0; j < matrix[row].length; j++) {
      matrix[row][j] = 0;
    }
  }
}
