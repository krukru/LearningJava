package kru.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KeyValuePairTest {

  KeyValuePair<Integer, String> keyValuePair = new KeyValuePair<>(1, "Hey");

  @Test
  public void testGetKey() throws Exception {
    assertEquals(keyValuePair.getKey(), new Integer(1));
  }

  @Test
  public void testGetValue() throws Exception {
    assertEquals(keyValuePair.getValue(), "Hey");
  }

  @Test
  public void testSetValue() throws Exception {
    String newValue = "Wazzzaaap";
    keyValuePair.setValue(newValue);
    assertEquals(keyValuePair.getValue(), newValue);
  }

  @Test
  public void testEquals() throws Exception {
    KeyValuePair<Integer, String> secondKeyValuePair = new KeyValuePair<Integer, String>(1, "Hey");
    assertTrue(secondKeyValuePair.equals(keyValuePair));
    assertTrue(keyValuePair.equals(secondKeyValuePair));
  }
}
