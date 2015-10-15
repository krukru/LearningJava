package kru.util;

import org.junit.Test;

import kru.util.Tuple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TupleTest {

  @Test
  public void testGetItem1() throws Exception {
    Tuple<Integer, Integer> t = Tuple.create(5, 20);
    assertEquals(5, t.getItem1().intValue());
  }

  @Test
  public void testGetItem2() throws Exception {
    Tuple<Integer, Integer> t = new Tuple<>(5, 20);
    assertEquals(Integer.valueOf(20), t.getItem2());
  }

  @Test
  public void testEquals() throws Exception {
    Tuple<Integer, Integer> t1 = Tuple.create(5, 20);
    Tuple<Integer, Integer> t2 = new Tuple<>(5, 20);
    Tuple<Integer, Integer> t3 = new Tuple<>(20, 5);
    Tuple<Integer, Integer> t4 = new Tuple<>(5, 5);
    assertTrue(t1.equals(t2));
    assertFalse(t1.equals(t3));
    assertFalse(t1.equals(t4));
  }
}
