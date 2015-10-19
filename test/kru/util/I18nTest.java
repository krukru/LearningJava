package kru.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class I18nTest {

  private I18n i18n = new I18n();

  @Test
  public void testShorten() throws Exception {
    String s1 = "Internationalization";
    assertEquals("I18n", i18n.shorten(s1));
  }
}
