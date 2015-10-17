package kru.ctci.chapter3.problem4;

import kru.collections.Stack;

public class HanoiTower {

  private Stack<HanoiDisc> dataStorage = new Stack<>();
  private final String label;

  public HanoiTower(String label) {
    this(label, 0);
  }

  public HanoiTower(String label, int numberOfDiscs) {
    this.label = label;
    for (int i = numberOfDiscs; i > 0; i--) {
      HanoiDisc disc = new HanoiDisc(i);
      dataStorage.push(disc);
    }
  }

  public HanoiMove moveDiscTo(HanoiTower moveToTower) {
    HanoiDisc movingDisc = dataStorage.pop();
    moveToTower.dataStorage.push(movingDisc);
    return new HanoiMove(this, moveToTower, movingDisc);
  }

  public int size() {
    return dataStorage.size();
  }

  @Override
  public String toString() {
    return label;
  }
}
