package kru.misc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExcelHelperTest {

  private ExcelHelper excelHelper = new ExcelHelper();

  @Test
  public void testColumnNumberToLetterCode() throws Exception {
    assertEquals("A", excelHelper.columnNumberToLetterCode(1));
    assertEquals("B", excelHelper.columnNumberToLetterCode(2));
    assertEquals("Z", excelHelper.columnNumberToLetterCode(26));
    assertEquals("AA", excelHelper.columnNumberToLetterCode(27));
    assertEquals("AB", excelHelper.columnNumberToLetterCode(28));
    assertEquals("AZ", excelHelper.columnNumberToLetterCode(52));
    assertEquals("BA", excelHelper.columnNumberToLetterCode(53));
    assertEquals("NI", excelHelper.columnNumberToLetterCode(373));
  }
}