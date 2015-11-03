package kru.misc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kru.collections.ArrayList;

public class ArrayHelperTest {

  private ArrayHelper arrayHelper = new ArrayHelper();

  @Test
  public void testDivideArrayIntoEqualSize() throws Exception {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    arrayList.add(6);
    arrayList.add(7);
    arrayList.add(8);
    ArrayList<Integer>[] result = arrayHelper.divideArrayIntoEqualSize(arrayList, 5);
    assertEquals(5, result.length);
    assertEquals(2, result[0].size());
    assertEquals(2, result[1].size());
    assertEquals(2, result[2].size());
    assertEquals(1, result[3].size());
    assertEquals(1, result[4].size());
    assertArrayEquals(new Integer[]{1, 2}, result[0].toArray());
    assertArrayEquals(new Integer[]{3, 4}, result[1].toArray());
    assertArrayEquals(new Integer[]{5, 6}, result[2].toArray());
    assertArrayEquals(new Integer[]{7}, result[3].toArray());
    assertArrayEquals(new Integer[]{8}, result[4].toArray());
  }

  @Test
  public void testDivideArrayIntoEqualSum() throws Exception {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(100);
    arrayList.add(25);
    arrayList.add(25);
    arrayList.add(25);
    arrayList.add(25);
    ArrayList<Integer>[] result = arrayHelper.divideArrayIntoEqualSum(arrayList, 2);
    assertEquals(2, result.length);
    assertEquals(1, result[0].size());
    assertEquals(4, result[1].size());
    assertArrayEquals(new Integer[]{100}, result[0].toArray());
    assertArrayEquals(new Integer[]{25, 25, 25, 25}, result[1].toArray());
  }
}