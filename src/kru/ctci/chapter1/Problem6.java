package kru.ctci.chapter1;

import kru.util.Tuple;

public class Problem6 {
  public void rotateInPlace(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    if (height != width) {
      throw new IllegalArgumentException("Cannot rotate non square matrix in-place");
    }
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < (height - (2 * i)) - 1; j++) {
        /* every time we increase i we eliminate two corners
         * That's why height - (2 * i)
         * We also don't want to rotate the last element,
         * since it is already rotated.
         * */
        Tuple<Integer, Integer> p1 = Tuple.create(i, i + j);
        Tuple<Integer, Integer> p2 = getRotatedCoordinates(p1.getItem1(), p1.getItem2(), height);
        Tuple<Integer, Integer> p3 = getRotatedCoordinates(p2.getItem1(), p2.getItem2(), height);
        Tuple<Integer, Integer> p4 = getRotatedCoordinates(p3.getItem1(), p3.getItem2(), height);
        int temp1 = matrix[p1.getItem1()][p1.getItem2()];
        int temp2 = matrix[p2.getItem1()][p2.getItem2()];
        int temp3 = matrix[p3.getItem1()][p3.getItem2()];
        int temp4 = matrix[p4.getItem1()][p4.getItem2()];
        matrix[p1.getItem1()][p1.getItem2()] = temp4;
        matrix[p2.getItem1()][p2.getItem2()] = temp1;
        matrix[p3.getItem1()][p3.getItem2()] = temp2;
        matrix[p4.getItem1()][p4.getItem2()] = temp3;
      }
    }
  }

  private Tuple<Integer, Integer> getRotatedCoordinates(int i, int j, int matrixSize) {
    return new Tuple<Integer, Integer>(j, matrixSize - 1 - i);
  }

  private int getRotatedPoint(int[][] matrix, int i, int j) {
    int matrixSize = matrix.length - 1;
    return matrix[j][matrixSize - i];
  }
}
