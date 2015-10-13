package kru.ctci.chapter1;

import kru.util.Tuple;

public class Problem6 {
  public void rotateInPlace(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    if (height != width) {
      throw new IllegalArgumentException("Cannot rotate non square matrix in-place");
    }
    for (int i = 0; i < height * width / 2; i++) {
      Tuple<Integer, Integer> point = arrayToMatrixCoordinates(i, width);
      Tuple<Integer, Integer> mirrorPoint = new Tuple<Integer, Integer>()
    }
  }

  private Tuple<Integer, Integer> arrayToMatrixCoordinates(int index, int matrixWidth) {
    int i = index / matrixWidth;
    int j = index - i;
    return new Tuple<Integer, Integer>(i, j);
  }
}
