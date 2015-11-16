package kru.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class NumbersHelperTest {

  private NumbersHelper nh = new NumbersHelper();

  @Test
  public void basicTest1() throws Exception {
    float[] a1 = new float[0];
    float[] a2 = new float[0];
    List<Range> result = nh.getMissingNumbers(a1, a2);
    assertEquals(1, result.size());
    Range r1 = result.get(0);
    assertEquals(Float.NEGATIVE_INFINITY, r1.getLowerBound(), 0);
    assertEquals(Float.POSITIVE_INFINITY, r1.getUpperBound(), 0);
  }
}