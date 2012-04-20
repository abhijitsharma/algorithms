package graph;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class Edge {
    private Vertex v1;
    private Vertex v2;
    private boolean directed = false;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.v1.addOut(this);
        this.v2.addIn(this);
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public boolean isDirected() {
        return directed;
    }

    @Override
    public String toString() {
        return "Edge{" +
                v1 +
                "->" + v2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!v2.equals(edge.v2)) return false;
        if (!v1.equals(edge.v1)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = v1.hashCode();
        result = 31 * result + v2.hashCode();
        return result;
    }
}
