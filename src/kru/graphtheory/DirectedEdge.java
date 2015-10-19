package kru.graphtheory;

public class DirectedEdge {
  private Vertex fromVertex;
  private Vertex toVertex;

  public DirectedEdge(Vertex fromVertex, Vertex toVertex) {
    this.fromVertex = fromVertex;
    this.toVertex = toVertex;
  }

  public Vertex getFromVertex() {
    return fromVertex;
  }

  public Vertex getToVertex() {
    return toVertex;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object == this) {
      return true;
    }
    if (object instanceof DirectedEdge) {
      DirectedEdge secondEdge = (DirectedEdge) object;
      return fromVertex.equals(secondEdge.fromVertex) && toVertex.equals(secondEdge.toVertex);
    } else {
      return false;
    }
  }
}
