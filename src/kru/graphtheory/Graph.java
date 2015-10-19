package kru.graphtheory;

import kru.collections.HashSet;

public class Graph {

  private HashSet<Vertex> vertices;
  private HashSet<Edge> edges;

  public Vertex addVertex() {
    return addVertex(String.format("Vertex %1$s", numberOfVertices() + 1));
  }

  public Vertex addVertex(String vertexLabel) {
    Vertex v = new Vertex(vertexLabel);
    vertices.add(v);
    return v;
  }

  public Edge connectVertices(Vertex v1, Vertex v2) {
    if (vertices.contains(v1) == false || vertices.contains(v2) == false) {
      throw new IllegalArgumentException("Vertices not part of graph");
    }
    Edge e = new Edge(v1, v2);
    edges.add(e);
    return e;
  }

  public int numberOfVertices() {
    return vertices.size();
  }

  public boolean hasEdge(Edge edge) {
    return edges.contains(edge);
  }
}
