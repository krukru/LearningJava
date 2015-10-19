package kru.regex;

/**
 * Regex supports only letters, ? and *
 */
public class SimpleRegex {
  public boolean matchesPattern(String pattern, String input) {
    return matchesPattern(pattern, input, 0, 0);
  }

  private boolean matchesPattern(String pattern, String input, int startingPatternIndex, int
      inputIndex) {
    if (startingPatternIndex >= pattern.length() && inputIndex >= input.length()) {
      return true;
    }
    if (inputIndex >= input.length()) {
      return false;
    }
    for (int patternIndex = startingPatternIndex; patternIndex < pattern.length();
         patternIndex++, inputIndex++) {
      char patternCharacter = pattern.charAt(patternIndex);
      if (Character.isLetter(patternCharacter)) {
        if (patternCharacter != input.charAt(inputIndex)) {
          return false;
        }
      } else if (patternCharacter == '?') {
        /* no operation, just passes */
      } else if (patternCharacter == '*') {
        return matchesPattern(pattern, input, patternIndex, inputIndex + 1) || matchesPattern
            (pattern, input, patternIndex + 1, inputIndex + 1) || matchesPattern(pattern, input,
            patternIndex + 1, inputIndex);
      } else {
        throw new IllegalArgumentException("Unsupported character in pattern");
      }
    }
    return true;
  }
}
