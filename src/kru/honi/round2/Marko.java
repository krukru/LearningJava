package kru.honi.round2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Marko {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int dictionarySize = Integer.parseInt(scanner.nextLine());
    HashMap<Integer, LinkedList<String>> dictionary = new HashMap<>();
    for (int i = 0; i < dictionarySize; i++) {
      String word = scanner.nextLine();
      if (dictionary.containsKey(word.length()) == false) {
        dictionary.put(word.length(), new LinkedList<>());
      }
      dictionary.get(word.length()).addLast(word);
    }
    String lookupMask = scanner.nextLine();
    int numberOfMatches = numberOfConflicts(dictionary, lookupMask);
    System.out.println(numberOfMatches);
  }


  private static int numberOfConflicts(HashMap<Integer, LinkedList<String>> dictionary, String
      lookupMask) {
    if (dictionary.containsKey(lookupMask.length()) == false) {
      return 0;
    }
    int result = 0;
    LinkedList<String> candidateWords = dictionary.get(lookupMask.length());
    for (String word : candidateWords) {
      if (t9MaskMatches(word, lookupMask)) {
        result += 1;
      }
    }
    return result;
  }

  private static boolean t9MaskMatches(String word, String lookupMask) {
    //assert that they are of same length
    for (int i = 0; i < word.length(); i++) {
      if (characterCode(word.charAt(i)) != lookupMask.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private static char characterCode(char letter) {
    if (letter >= 'a' && letter <= 'c') {
      return '2';
    } else if (letter >= 'd' && letter <= 'f') {
      return '3';
    } else if (letter >= 'g' && letter <= 'i') {
      return '4';
    } else if (letter >= 'j' && letter <= 'l') {
      return '5';
    } else if (letter >= 'm' && letter <= 'o') {
      return '6';
    } else if (letter >= 'p' && letter <= 's') {
      return '7';
    } else if (letter >= 't' && letter <= 'v') {
      return '8';
    } else if (letter >= 'w' && letter <= 'z') {
      return '9';
    } else {
      throw new IllegalArgumentException();
    }
  }
}
