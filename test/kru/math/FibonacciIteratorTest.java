package kru.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciIteratorTest {

  @Test
  public void basicTest() throws Exception {
    FibonacciIterator fibIt = new FibonacciIterator();
    assertTrue(fibIt.hasNext());
    assertEquals(1, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(1, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(2, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(3, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(5, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(8, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(13, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(21, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
  }

  @Test
  public void basicTest_WithBounds() throws Exception {
    FibonacciIterator fibIt = new FibonacciIterator(5);
    assertTrue(fibIt.hasNext());
    assertEquals(1, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(1, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(2, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(3, fibIt.next().intValue());
    assertTrue(fibIt.hasNext());
    assertEquals(5, fibIt.next().intValue());
    assertFalse(fibIt.hasNext());
    try {
      fibIt.next();
      fail();
    } catch (Exception ex) {
      /* test passed */
    }
  }
}
