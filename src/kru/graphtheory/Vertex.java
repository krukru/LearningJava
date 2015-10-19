package kru.graphtheory;

public class Vertex {
  private String label;

  public Vertex() {}

  public Vertex(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }
}
