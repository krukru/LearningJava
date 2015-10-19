package kru.graphtheory;

import kru.collections.HashSet;

public class DirectedGraph {

  private HashSet<Vertex> vertices;
  private HashSet<DirectedEdge> directedEdges;

  public Vertex addVertex() {
    return addVertex(String.format("Vertex %1$s", numberOfVertices() + 1));
  }

  public Vertex addVertex(String vertexLabel) {
    Vertex v = new Vertex(vertexLabel);
    vertices.add(v);
    return v;
  }

  public DirectedEdge connectVertices(Vertex fromVertex, Vertex toVertex) {
    if (vertices.contains(fromVertex) == false || vertices.contains(toVertex) == false) {
      throw new IllegalArgumentException("Vertices not part of graph");
    }
    DirectedEdge directedEdge = new DirectedEdge(fromVertex, toVertex);
    directedEdges.add(directedEdge);
    return directedEdge;
  }

  public int numberOfVertices() {
    return vertices.size();
  }

  public boolean hasEdge(Edge edge) {
    return directedEdges.contains(edge);
  }
}
