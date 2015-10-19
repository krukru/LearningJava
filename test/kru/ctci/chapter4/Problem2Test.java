package kru.ctci.chapter4;

import kru.graphtheory.DirectedGraph;
import kru.graphtheory.Vertex;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem2Test {

  Problem2 p2 = new Problem2();

  @Test
  public void testExistsPath_DFS() throws Exception {
    DirectedGraph digraph = new DirectedGraph();
    final Problem2.SolutionType solutionTypeDFS = Problem2.SolutionType.DFS;
    Vertex v1 = digraph.addVertex();
    Vertex v2 = digraph.addVertex();
    Vertex v3 = digraph.addVertex();
    Vertex v4 = digraph.addVertex();
    digraph.connectVertices(v1, v2);
    digraph.connectVertices(v2, v3);
    digraph.connectVertices(v2, v4);
    assertTrue(p2.existsPath(digraph, v1, v2, solutionTypeDFS));
    assertTrue(p2.existsPath(digraph, v1, v3, solutionTypeDFS));
    assertTrue(p2.existsPath(digraph, v1, v4, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v2, v1, solutionTypeDFS));
    assertTrue(p2.existsPath(digraph, v2, v3, solutionTypeDFS));
    assertTrue(p2.existsPath(digraph, v2, v4, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v3, v1, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v3, v2, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v3, v4, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v4, v1, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v4, v2, solutionTypeDFS));
    assertFalse(p2.existsPath(digraph, v4, v3, solutionTypeDFS));
  }

  @Test
  public void testExistsPath_BFS() throws Exception {
    DirectedGraph digraph = new DirectedGraph();
    final Problem2.SolutionType solutionTypeBFS = Problem2.SolutionType.BFS;
    Vertex v1 = digraph.addVertex();
    Vertex v2 = digraph.addVertex();
    Vertex v3 = digraph.addVertex();
    Vertex v4 = digraph.addVertex();
    digraph.connectVertices(v1, v2);
    digraph.connectVertices(v2, v3);
    digraph.connectVertices(v2, v4);
    assertTrue(p2.existsPath(digraph, v1, v2, solutionTypeBFS));
    assertTrue(p2.existsPath(digraph, v1, v3, solutionTypeBFS));
    assertTrue(p2.existsPath(digraph, v1, v4, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v2, v1, solutionTypeBFS));
    assertTrue(p2.existsPath(digraph, v2, v3, solutionTypeBFS));
    assertTrue(p2.existsPath(digraph, v2, v4, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v3, v1, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v3, v2, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v3, v4, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v4, v1, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v4, v2, solutionTypeBFS));
    assertFalse(p2.existsPath(digraph, v4, v3, solutionTypeBFS));
  }
}
