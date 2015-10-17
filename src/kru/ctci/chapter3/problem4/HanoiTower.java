package kru.ctci.chapter3.problem4;

import kru.collections.Stack;

public class HanoiTower extends Stack<HanoiDisc> {
  private final char label;

  public HanoiTower(char label) {
    this.label = label;
  }
}
