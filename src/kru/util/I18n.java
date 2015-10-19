package kru.util;

public class I18n {

  public String shorten(String input) {
    if (input.length() <= 2) {
      return input;
    }
    Integer i18Length = input.length() - 2;
    Character firstCharacter = input.charAt(0);
    Character lastCharacter = input.charAt(input.length() - 1);
    return String.format("%1$s%2$s%3$s", firstCharacter, i18Length, lastCharacter);
  }
}
