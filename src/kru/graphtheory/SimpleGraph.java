package kru.graphtheory;

public class SimpleGraph {

  private Graph graph = new Graph();

  public Vertex addVertex() {
    return graph.addVertex();
  }

  public Vertex addVertex(String vertexLabel) {
    return graph.addVertex(vertexLabel);
  }

  public Edge connectVertices(Vertex v1, Vertex v2) {
    if (v1 == v2) {
      throw new IllegalStateException("Simple graph cannot have a loop.");
    }
    if (graph.hasEdge(new Edge(v1, v2))) {
      throw new IllegalStateException("Simple graph cannot have multiple edges");
    }
    return graph.connectVertices(v1, v2);
  }

  public int numberOfVertices() {
    return graph.numberOfVertices();
  }
}
