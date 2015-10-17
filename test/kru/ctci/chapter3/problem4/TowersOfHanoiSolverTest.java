package kru.ctci.chapter3.problem4;

import kru.collections.LinkedList;
import kru.collections.Stack;
import org.junit.Test;

import static org.junit.Assert.*;

public class TowersOfHanoiSolverTest {

  TowersOfHanoiSolver solver = new TowersOfHanoiSolver();

  @Test
  public void testSolve_NumberOfDiscs_1() {
    int numberOfDiscs = 1;
    LinkedList<HanoiMove> solution = solver.solve(numberOfDiscs);
    runSimulator(solution, numberOfDiscs);
  }

  @Test
  public void testSolve_NumberOfDiscs_2() {
    int numberOfDiscs = 2;
    LinkedList<HanoiMove> solution = solver.solve(numberOfDiscs);
    runSimulator(solution, numberOfDiscs);
  }

  @Test
  public void testSolve_NumberOfDiscs_5() {
    int numberOfDiscs = 5;
    LinkedList<HanoiMove> solution = solver.solve(numberOfDiscs);
    runSimulator(solution, numberOfDiscs);
  }

  private void runSimulator(LinkedList<HanoiMove> moves, int numberOfDiscs) {
    HanoiTower t1 = new HanoiTower("Tower A", numberOfDiscs);
    HanoiTower t2 = new HanoiTower("Tower B");
    HanoiTower t3 = new HanoiTower("Tower C");
    for (HanoiMove move : moves) {
      HanoiTower fromTower;
      HanoiTower toTower;
      if (move.getFromTower().toString().equals("Tower A")) {
        fromTower = t1;
      } else if (move.getFromTower().toString().equals("Tower B")) {
        fromTower = t2;
      } else {
        fromTower = t3;
      }
      if (move.getToTower().toString().equals("Tower A")) {
        toTower = t1;
      } else if (move.getToTower().toString().equals("Tower B")) {
        toTower = t2;
      } else {
        toTower = t3;
      }
      HanoiMove realMove = fromTower.moveDiscTo(toTower);
      assertEquals(move.getMovingDisc().getWidth(), realMove.getMovingDisc().getWidth());
    }
    assertEquals(0, t1.size());
    assertEquals(0, t2.size());
    assertEquals(numberOfDiscs, t3.size());
  }
}
