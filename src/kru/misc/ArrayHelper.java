package kru.misc;

import java.util.Collections;
import java.util.Iterator;

import kru.collections.ArrayList;

public class ArrayHelper {


  /**
   * Divides the array into chunks of similar sum
   */
  public ArrayList<Integer>[] divideArrayIntoEqualSize(ArrayList<Integer> array, int
      numberOfChunks) {
    if (numberOfChunks <= 0) {
      throw new IllegalArgumentException();
    }
    ArrayList<Integer>[] result = new ArrayList[numberOfChunks];
    int chunkSize = array.size() / numberOfChunks;
    int overflowCount = array.size() % numberOfChunks;
    int startIndex = 0;
    for (int i = 0; i < numberOfChunks; i++) {
      int endIndex;
      if (overflowCount > 0) {
        endIndex = startIndex + chunkSize + 1;
        overflowCount -= 1;
      } else {
        endIndex = startIndex + chunkSize;
      }
      result[i] = new ArrayList<>(array.subList(startIndex, endIndex));
      startIndex = endIndex;
    }
    return result;
  }


  /**
   * Greedy, doesn't have to be optimal
   *
   * @param array
   * @param numberOfChunks
   * @return
   */
  public ArrayList<Integer>[] divideArrayIntoEqualSum(ArrayList<Integer> array, int
      numberOfChunks) {
    if (numberOfChunks <= 0) {
      throw new IllegalArgumentException();
    }
    ArrayList<Integer>[] result = new ArrayList[numberOfChunks];
    for (int i = 0; i < numberOfChunks; i++) {
      result[i] = new ArrayList<>();
    }
    Collections.sort(array, (o1, o2) -> -1 * o1.compareTo(o2));
    int average = (int)getAverage(array);
    int bucketPointer = 0;

    Iterator<Integer> iterator = array.iterator();
    int bucketSum = 0;
    while (iterator.hasNext()) {
      int number = iterator.next();
      if (bucketSum < average) {
        bucketSum += number;
      } else {
        bucketSum = 0;
        bucketPointer = Math.min(bucketPointer + 1, numberOfChunks - 1);
      }
      result[bucketPointer].add(number);
    }
    return result;
  }

  private double getAverage(ArrayList<Integer> array) {
    int sum = 0;
    for (int number : array) {
      sum += number;
    }
    return sum / array.size();
  }
}
