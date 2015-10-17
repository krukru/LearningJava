package kru.ctci.chapter3.problem4;

public class HanoiDisc {
  private final int width;

  public HanoiDisc(int width) {
    this.width = width;
  }

  public int getWidth() {
    return width;
  }

  public String toString() {
    return String.valueOf(width);
  }
}
