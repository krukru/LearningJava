package kru.honi.round1;

import org.junit.Test;

import static org.junit.Assert.*;

public class KarteTest {

  private Karte karte = new Karte();

  @Test
  public void testExample1() throws Exception {
    String input = "P01K02H03H04";
    String expectedOutput = "12 12 11 13";
    assertEquals(expectedOutput, karte.solve(input));
  }

  @Test
  public void testExample2() throws Exception {
    String input = "H02H10P11H02";
    String expectedOutput = "GRESKA";
    assertEquals(expectedOutput, karte.solve(input));
  }

  @Test
  public void testExample3() throws Exception {
    String input = "P10K10H10T01";
    String expectedOutput = "12 12 12 12";
    assertEquals(expectedOutput, karte.solve(input));
  }
}
