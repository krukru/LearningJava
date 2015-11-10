package kru.honi.round2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TntTest {

  @Test
  public void testGetRemainingMoney() throws Exception {
    Tnt tnt = new Tnt();
    assertEquals(80, tnt.getRemainingMoney(100, 5));
    assertEquals(5, tnt.getRemainingMoney(70, 10));
    assertEquals(0, tnt.getRemainingMoney(44, 8));
  }
}