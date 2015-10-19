package kru.util;

import kru.collections.HashSet;

import java.util.Collection;

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

  public boolean doesCollectionUniquelyAbbreviate(Collection<String> stringsToShorten) {
    boolean result = true; //we start by assumend it's true and work our way trying to disprove it.
    HashSet<String> lookup = new HashSet<>();
    for (String input : stringsToShorten) {
      String i18nAbbreviation = shorten(input);
      if (lookup.contains(i18nAbbreviation)) {
        result = false;
        break;
      } else {
        lookup.add(i18nAbbreviation);
      }
    }
    return result;
  }
}
