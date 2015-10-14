package kru.ctci.chapter1;

import kru.collections.ArrayList;
import kru.util.Tuple;

import java.util.List;

public class Problem7 {

  private static final int ERASURE_NUMBER = 0;

  public void replaceItemsInRowAndColumn(int[][] matrix) {
    List<Tuple<Integer, Integer>> erasurePoints = new ArrayList<>();
    int height = matrix.length;
    int width = matrix[0].length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (matrix[i][j] == ERASURE_NUMBER) {
          erasurePoints.add(Tuple.create(i, j));
        }
      }
    }
    for (Tuple<Integer, Integer> point : erasurePoints) {
      for (int i = 0; i < height; i++) {
        matrix[i][point.getItem2()] = ERASURE_NUMBER;
      }
      for (int j = 0; j < width; j++) {
        matrix[point.getItem1()][j] = ERASURE_NUMBER;
      }
    }
  }
}
