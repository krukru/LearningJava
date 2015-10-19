package kru.ctci.chapter4;

import kru.collections.HashSet;
import kru.collections.LinkedList;
import kru.collections.Queue;
import kru.exception.runtimexception.NotImplementedException;
import kru.graphtheory.DirectedGraph;
import kru.graphtheory.Vertex;

public class Problem2 {

  public enum SolutionType {
    DFS,
    BFS
  }

  public boolean existsPath(DirectedGraph graph, Vertex fromVertex, Vertex toVertex) {
    return existsPathDepthFirstSearch(graph, fromVertex, toVertex);
  }

  public boolean existsPath(DirectedGraph graph, Vertex fromVertex, Vertex toVertex, SolutionType
      solutionType) {
    if (solutionType == SolutionType.DFS) {
      return existsPathDepthFirstSearch(graph, fromVertex, toVertex);
    } else if (solutionType == SolutionType.BFS) {
      return existsPathBreadthFirstSearch(graph, fromVertex, toVertex);
    } else {
      throw new NotImplementedException();
    }
  }

  private boolean existsPathDepthFirstSearch(DirectedGraph graph, Vertex fromVertex, Vertex
      toVertex) {
    HashSet<Vertex> visitedVertices = new HashSet<>();
    return existsPathDepthFirstSearch(graph, fromVertex, toVertex, visitedVertices);
  }

  private boolean existsPathBreadthFirstSearch(DirectedGraph graph, Vertex fromVertex, Vertex
      toVertex) {
    boolean result = false;
    HashSet<Vertex> visitedVertices = new HashSet<>();
    Queue<Vertex> pendingVertices = new Queue<>();
    pendingVertices.enqueue(fromVertex);
    while (pendingVertices.size() > 0) {
      Vertex currentVertex = pendingVertices.dequeue();
      if (currentVertex == toVertex) {
        result = true;
        break;
      }
      pendingVertices.addAll(graph.getAdjecentVertices(currentVertex));
    }
    return result;
  }

  private boolean existsPathDepthFirstSearch(DirectedGraph graph, Vertex currentVertex, Vertex
      targetVertex, HashSet<Vertex> visitedVertices) {
    if (currentVertex == targetVertex) {
      return true;
    }
    visitedVertices.add(currentVertex);
    HashSet<Vertex> adjecentVertices = graph.getAdjecentVertices(currentVertex);
    for (Vertex v : adjecentVertices) {
      boolean pathExists = existsPathDepthFirstSearch(graph, v, targetVertex, adjecentVertices);
      if (pathExists) {
        return true;
      }
    }
    return false;
  }
}
