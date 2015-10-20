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

  @Test
  public void testNumber10() throws Exception {
    String input = "P05P01P02P03P13P09P11P07K01P12K03K02K13K12K10K08H03H02H13H12H10H08T01T03T02T13T12T10T08P04K07H02T07H06T11K11T05K05H05H11";
    String expectedOutput = "GRESKA";
    assertEquals(expectedOutput, karte.solve(input));
  }

  @Test
  public void testNumber9() throws Exception {
    String input = "P05P01P02P03P13P09P11P07K01P12K03K02K13K12K10K08H03H02H13H12H10H08T01T03T02T13T12T10T08P04K07K06T07H06T11K11T05K05H05H11";
    String expectedOutput = "3 2 4 3";
    assertEquals(expectedOutput, karte.solve(input));
  }
}
