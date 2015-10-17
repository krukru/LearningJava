package kru.ctci.chapter3.problem4;

public class HanoiMove {
  private final HanoiTower fromTower;
  private final HanoiTower toTower;

  public HanoiMove(HanoiTower fromTower, HanoiTower toTower) {
    this.fromTower = fromTower;
    this.toTower = toTower;
  }

  public HanoiTower getFromTower() {
    return fromTower;
  }

  public HanoiTower getToTower() {
    return toTower;
  }
}

