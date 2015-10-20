package kru.honi.round1;

import kru.collections.HashSet;

public class Karte {

  private static final String ERROR = "GRESKA";
  private static final int NUMBER_OF_CARDS_PER_SUITE = 13;

  private HashSet<Integer> pikLookup = new HashSet<>();
  private HashSet<Integer> karoLookup = new HashSet<>();
  private HashSet<Integer> hercLookup = new HashSet<>();
  private HashSet<Integer> trefLookup = new HashSet<>();

  public String solve(String input) {
    if (input.length() % 3 != 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < input.length(); i += 3) {
      Character cardSuite = input.charAt(i);
      int cardNumber = Integer.parseInt(input.substring(i + 1, i + 3));
      HashSet<Integer> suiteLookup = getSuiteLookup(cardSuite);
      if (suiteLookup.contains(cardNumber)) {
        return ERROR;
      } else {
        suiteLookup.add(cardNumber);
      }
    }
    return String.format("%1$s %2$s %3$s %4$s",
        NUMBER_OF_CARDS_PER_SUITE - pikLookup.size(),
        NUMBER_OF_CARDS_PER_SUITE - karoLookup.size(),
        NUMBER_OF_CARDS_PER_SUITE - hercLookup.size(),
        NUMBER_OF_CARDS_PER_SUITE - trefLookup.size());
  }

  private HashSet<Integer> getSuiteLookup(Character cardSuite) {
    switch (cardSuite) {
      case 'P':
        return pikLookup;
      case 'K':
        return karoLookup;
      case 'H':
        return hercLookup;
      case 'T':
        return trefLookup;
      default:
        throw new IllegalArgumentException("Not a valid card suite");
    }
  }
}
