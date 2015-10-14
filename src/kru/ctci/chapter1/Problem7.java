package kru.ctci.chapter1;

import kru.collections.ArrayList;

import java.collections.List;

public class Problem7 {

  private static final ERASURE_NUMBER = 0;

  /* To Do: refactor so this methods calls internalReplace
   * void internalReplace(int[][] matrix, int erasurNumber, int replaceWithNumber);
   **/
  public void replaceItemsInRowAndColumn(int[][] matrix) {
    List<Tuple<Integer, Integer>> erasurePoints = new ArrayList<>();
    int height = matrix.length();
    int width = matrix[0].length();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (matrix[i][j] == ERASURE_NUMBER) {
          erasurePoints.add(Tuple.create(i, j)); /* Boxing required? */
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
