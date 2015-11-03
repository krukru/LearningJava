package kru.misc;

public class ExcelHelper {
  public String columnNumberToLetterCode(int columnNumber) {
    if (columnNumber <= 0) {
      throw new IllegalArgumentException();
    }
    return toBase26String(columnNumber);
  }

  private String toBase26String(int base10Number) {
    StringBuilder sb = new StringBuilder();
    while (base10Number > 0) {
      int reminder = base10Number % 26;
      base10Number = base10Number / 26;
      char numberRepresentation = (char)('A' - reminder + 1);
      sb.append(numberRepresentation);
    }
    return sb.reverse().toString();
  }
}

