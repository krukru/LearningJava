package kru.ctci.chapter3.problem4;

import kru.collections.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class TowersOfHanoiSolverTest {

  TowersOfHanoiSolver solver = new TowersOfHanoiSolver();

  @Test
  public void testSolve() throws Exception {
    LinkedList<HanoiMove> solution = solver.solve(5);
    assertTrue(solution.size() > 0);
  }
}
