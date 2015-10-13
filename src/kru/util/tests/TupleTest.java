package kru.util.tests;

import org.junit.Test;

import kru.util.Tuple;

import static org.junit.Assert.*;

public class TupleTest {

  Tuple<Integer, String> tuple = new Tuple<>(1, "Hey");

  @Test
  public void testGetKey() throws Exception {
    assertEquals(tuple.getKey(), new Integer(1));
  }

  @Test
  public void testGetValue() throws Exception {
    assertEquals(tuple.getValue(), "Hey");
  }

  @Test
  public void testSetValue() throws Exception {
    String newValue = "Wazzzaaap";
    tuple.setValue(newValue);
    assertEquals(tuple.getValue(), newValue);
  }

  @Test
  public void testEquals() throws Exception {
    Tuple<Integer, String> secondTuple = new Tuple<Integer, String>(1, "Hey");
    assertTrue(secondTuple.equals(tuple));
    assertTrue(tuple.equals(secondTuple));
  }
}