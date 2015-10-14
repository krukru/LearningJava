package kru.util.testing;

import org.junit.Test;

import kru.util.Nullable;

import static org.junit.Assert.*;

public class NullableTest {

  @Test
  public void testHasValue() throws Exception {
    Nullable<Integer> nullableInt = new Nullable<>();
    assertFalse(nullableInt.hasValue());
    nullableInt.setValue(5);
    assertTrue(nullableInt.hasValue());
  }

  @Test
  public void testSetValue() throws Exception {
    Integer testNumber = 5;
    Nullable<Integer> nullableInt = new Nullable<>(testNumber);
    nullableInt.setValue(1024);
    assertEquals(new Integer(1024), nullableInt.getValue());
  }

  @Test
  public void testGetValue() throws Exception {
    Integer testNumber = 5;
    Nullable<Integer> nullableInt = new Nullable<>(testNumber);
    assertEquals(testNumber, nullableInt.getValue());
  }

  @Test
  public void testEquals() {
    Nullable<Integer> n1 = new Nullable<>(5);
    Nullable<Integer> n2 = new Nullable<>(5);
    Nullable<Integer> n3 = new Nullable<>(10);
    n3.setValue(5);
    final Integer five = 5;
    assertTrue(n1.equals(n2));
    assertTrue(n1.equals(n3));
    assertTrue(n1.equals(five));
    assertTrue(n1.hasValue());
    n1.setValue(null);
    assertFalse(n1.hasValue());
    assertFalse(n1.equals(five));
  }
}
