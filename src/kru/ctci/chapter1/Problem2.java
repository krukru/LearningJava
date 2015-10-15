package kru.ctci.chapter1;

public class Problem2 {

  public void reverse(char[] array) {
    int arrayLength = find('\0', array) - 1;
    for (int i = 0; i < arrayLength / 2; i++) {
      char tempCharacter = array[i];
      array[i] = array[arrayLength - 1 - i];
      array[arrayLength - 1 - i] = tempCharacter;
    }
  }

  private int find(char characterToFind, char[] array) {
    int index = 0;
    while (array[index++] != characterToFind) {
      if (index == array.length) {
        throw new IllegalArgumentException("Character not found");
      }
    }
    return index;
  }
}
