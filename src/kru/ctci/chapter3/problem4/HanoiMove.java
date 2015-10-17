package kru.ctci.chapter3.problem4;

public class HanoiMove {
  private final HanoiTower fromTower;
  private final HanoiTower toTower;
  private final HanoiDisc movingDisc;

  public HanoiMove(HanoiTower fromTower, HanoiTower toTower, HanoiDisc movingDisc) {
    this.fromTower = fromTower;
    this.toTower = toTower;
    this.movingDisc = movingDisc;
  }

  public HanoiTower getFromTower() {
    return fromTower;
  }

  public HanoiTower getToTower() {
    return toTower;
  }

  public HanoiDisc getMovingDisc() {
    return movingDisc;
  }
}

