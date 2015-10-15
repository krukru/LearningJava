package kru.ctci.chapter1;

import java.util.Arrays;

import kru.collections.HashMap;

public class Problem3 {
  /**
   * Depending on the size of the strings, there are a number of optimal solutions. One way would be
   * to sort the strings and check if they end up the same. Total time complexity is O(n*log n) for
   * sorting and then O(n) for the comparison which gives O(n*logn). A second solution would be to
   * count the number of letter appearances. For ASCII only strings, we could use a static array of
   * size 256. For UTF8 support we would need a HashMap.
   *
   * Time complexity is O(n), to fill up the hashtable. But also need O(n) space to store it.
   *
   * We further assume that anagrams are case insensitive. For example: hat is considered a
   * permutation of HAT
   */
  public boolean arePermutations(String s1, String s2, SolutionType solutionType) {
    /* Depending on the size of the strings, there are a number of optimal solutions
     * One way would be to sort the strings and check if they end up the same.
     * TOt
     * Another approach would be to count the characters that appear
     * For counting we could use a static array of size 256, but if unicode
     * support is required, we need to use a hashmap */
    boolean result;
    switch (solutionType) {
      case Sort:
        result = arePermutations_sorting(s1, s2);
        break;
      case CountAscii:
        result = arePermutations_AsciiOnly(s1, s2);
        break;
      case CountUnicode:
        result = arePermutations_Unicode(s1, s2);
        break;
      default:
        throw new RuntimeException("Behavior not defined for given enum");
    }
    return result;
  }

  public boolean arePermutations(String s1, String s2) {
    return arePermutations(s1, s2, SolutionType.CountUnicode);
  }

  private boolean arePermutations_sorting(String s1, String s2) {
    char[] a1 = s1.toLowerCase().toCharArray();
    char[] a2 = s2.toLowerCase().toCharArray();
    Arrays.sort(a1);
    Arrays.sort(a2);
    int length1 = a1.length;
    int length2 = a2.length;
    for (int i1 = 0, i2 = 0; i1 < Math.min(length1, length2); i1++) {
      if (Character.isLetterOrDigit(a1[i1]) == false) {
        continue;
      }
      while (i2 < length2 && Character.isLetterOrDigit(a2[i2]) == false) {
        i2++;
      }
      if (a1[i1] != a2[i2]) {
        return false;
      }
      i2++;
    }
    return true;
  }

  private boolean arePermutations_AsciiOnly(String s1, String s2) {
    final int numberOfAsciiCharacters = 256;
    int counter = 0;
    char[] lookup = new char[numberOfAsciiCharacters];
    for (char c : s1.toCharArray()) {
      if (Character.isLetterOrDigit(c) == false) {
        continue;
      }
      char lookupCharacter = Character.toLowerCase(c);
      lookup[lookupCharacter] += 1;
      counter += 1;
    }
    for (char c : s2.toCharArray()) {
      if (Character.isLetterOrDigit(c) == false) {
        continue;
      }
      char lookupCharacter = Character.toLowerCase(c);
      if (lookup[lookupCharacter] == 0) {
        return false;
      } else {
        lookup[lookupCharacter] -= 1;
        counter -= 1;
      }
    }
    return (counter == 0);
  }

  /**
   * This method is slightly slower then the Ascii version, but supported a broader range of
   * characters
   */
  private boolean arePermutations_Unicode(String s1, String s2) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      if (Character.isLetterOrDigit(c) == false) {
        continue;
      }
      int numberOfOccurences = 1;
      char lookupCharacter = Character.toLowerCase(c);
      if (map.containsKey(lookupCharacter)) {
        numberOfOccurences = map.get(lookupCharacter) + 1;
      }
      map.put(lookupCharacter, numberOfOccurences);
    }
    for (char c : s2.toCharArray()) {
      if (Character.isLetterOrDigit(c) == false) {
        continue;
      }
      char lookupCharacter = Character.toLowerCase(c);
      if (map.containsKey(lookupCharacter) == false) {
        return false;
      } else {
        int numberOfOccurences = map.get(lookupCharacter);
        if (numberOfOccurences == 1) {
          map.remove(lookupCharacter);
        } else {
          map.put(lookupCharacter, numberOfOccurences - 1);
        }
      }
    }
    return (map.size() == 0);
  }

  public enum SolutionType {
    Sort,
    CountAscii,
    CountUnicode
  }
}
