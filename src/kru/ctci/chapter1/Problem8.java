package kru.ctci.chapter1;

public class Problem8 {


  public boolean isRotation(String s1, String s2) {
    String duplicatedS1 = s1 + s1; /* Maybe you can't do this, see concat() */
    return isSubstring(duplicatedS1, s2);
  }

  private boolean isSubstring(String string, String candidateSubstring) {
    return string.toLowerCase().contains(candidateSubstring.toLowerCase());
  }
}
