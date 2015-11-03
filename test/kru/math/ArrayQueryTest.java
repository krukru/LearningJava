package kru.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayQueryTest {

  @Test
  public void basicTest() throws Exception {
    int[] array = new int[]{1, 2, 10, 3, 5, 2};
    ArrayQuery arrayQuery = new ArrayQuery(array);
    assertEquals(0, arrayQuery.sum(0, 0));
    assertEquals(1, arrayQuery.sum(0, 1));
    assertEquals(3, arrayQuery.sum(0, 2));
    assertEquals(13, arrayQuery.sum(0, 3));
    assertEquals(23, arrayQuery.sum(0, 6));
    assertEquals(2, arrayQuery.sum(1, 2));
    assertEquals(12, arrayQuery.sum(1, 3));
    assertEquals(13, arrayQuery.sum(2, 4));
    assertEquals(18, arrayQuery.sum(2, 5));

    arrayQuery.updateValue(0, 2);
    arrayQuery.updateValue(3, 3);

    assertEquals(0, arrayQuery.sum(0, 0));
    assertEquals(1, arrayQuery.sum(0, 1));
    assertEquals(3, arrayQuery.sum(0, 2));
    assertEquals(3, arrayQuery.sum(0, 3));
    assertEquals(11, arrayQuery.sum(0, 5));
    assertEquals(2, arrayQuery.sum(1, 2));
    assertEquals(2, arrayQuery.sum(1, 3));
    assertEquals(3, arrayQuery.sum(2, 4));
    assertEquals(8, arrayQuery.sum(2, 5));
  }


}