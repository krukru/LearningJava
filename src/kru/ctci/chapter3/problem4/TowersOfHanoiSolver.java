package kru.ctci.chapter3.problem4;

import kru.collections.LinkedList;

public class TowersOfHanoiSolver {

  public LinkedList<HanoiMove> solve(int numberOfDiscs) {
    HanoiTower t1 = new HanoiTower("Tower A", numberOfDiscs);
    HanoiTower t2 = new HanoiTower("Tower B");
    HanoiTower t3 = new HanoiTower("Tower C");
    LinkedList<HanoiMove> solution = moveStack(t1, t3, t2);
    return solution;
  }

  private LinkedList<HanoiMove> moveStack(HanoiTower fromTower, HanoiTower toTower, HanoiTower
      helperTower) {
    /* We move the stack by moving the top first N-1 discs to the assisting tower,
     * move the N-th disc to the destination tower, and move the stack from the assisting tower
     * to the destination .*/
    return moveStack(fromTower, toTower, helperTower, fromTower.size());
  }

  private LinkedList<HanoiMove> moveStack(HanoiTower fromTower, HanoiTower toTower, HanoiTower
      helperTower, int stackSize) {
    if (stackSize == 0) {
      return new LinkedList<>(); //a stack of 0 discs needs no moves to be moved
    }
    LinkedList<HanoiMove> solution = new LinkedList<>();
    LinkedList<HanoiMove> moveStackToHelperTower = moveStack(fromTower, helperTower, toTower,
        stackSize - 1);
    solution.addAll(moveStackToHelperTower);

    HanoiMove moveLastDisc = fromTower.moveDiscTo(toTower);
    solution.add(moveLastDisc);

    LinkedList<HanoiMove> moveStackToTargetTower = moveStack(helperTower, toTower, fromTower,
        stackSize - 1);
    solution.addAll(moveStackToTargetTower);
    return solution;
  }
}
