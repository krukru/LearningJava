package kru.math;

public class MatrixQuery {

  private ArrayQuery[] rowQueries;

  public MatrixQuery(int[][] matrix) {
    this.rowQueries = new ArrayQuery[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      rowQueries[i] = new ArrayQuery(matrix[i]);
    }
  }

  public int sum (int startX, int startY, int endX, int endY) {
    //let's forget about validation for the time being TODO
    //top left corner is 0,0
    if (startY == endY) {
      return rowQueries[startY].sum(startX, endX + 1); //we want to include the last element
    }
    int sum = 0;
    for (int i = startY; i <= endY; i++) {
      if (i == startY) {
        sum += rowQueries[i].sum(startX);
      } else if (i == endY) {
        sum += rowQueries[i].sum(0, endX + 1);
      } else {
        sum += rowQueries[i].sum(0);
      }
    }
    return sum;
  }
}