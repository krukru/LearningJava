package kru.util;

import kru.collections.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class I18nTest {

  private I18n i18n = new I18n();

  @Test
  public void testShorten() throws Exception {
    String s1 = "Internationalization";
    assertEquals("I18n", i18n.shorten(s1));
  }

  @Test
  public void testAreAbbreviationsUnique_PositiveTest() throws Exception {
    LinkedList<String> strings = new LinkedList<>();
    strings.addLast("aaa");
    strings.addLast("aab");
    strings.addLast("aac");
    assertTrue(i18n.doesCollectionUniquelyAbbreviate(strings));
  }

  @Test
  public void testAreAbbreviationsUnique_NegativeTest() throws Exception {
    LinkedList<String> strings = new LinkedList<>();
    strings.addLast("aaa");
    strings.addLast("aab");
    strings.addLast("aaa");
    assertFalse(i18n.doesCollectionUniquelyAbbreviate(strings));
  }
}
