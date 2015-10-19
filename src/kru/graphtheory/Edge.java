package kru.graphtheory;

public class Edge {
  private Vertex v1;
  private Vertex v2;

  public Edge(Vertex v1, Vertex v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  public Vertex getVertex1() {
    return v1;
  }

  public Vertex getVertex2() {
    return v2;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object == this) {
      return true;
    }
    if (object instanceof Edge) {
      Edge secondEdge = (Edge) object;
      return v1.equals(secondEdge.v1) && v2.equals(secondEdge.v2) || v1.equals(secondEdge.v2) &&
          v2.equals(secondEdge.v1);
    } else {
      return false;
    }
  }
}
