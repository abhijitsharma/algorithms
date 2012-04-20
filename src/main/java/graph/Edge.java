package graph;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class Edge {
    private Vertex src;
    private Vertex sink;

    public Edge(Vertex src, Vertex sink) {
        this.src = src;
        this.sink = sink;
        this.src.addOut(this);
        this.sink.addIn(this);
    }

    public Vertex getSrc() {
        return src;
    }

    public Vertex getSink() {
        return sink;
    }

    @Override
    public String toString() {
        return "Edge{" +
                src +
                "->" + sink +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!sink.equals(edge.sink)) return false;
        if (!src.equals(edge.src)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = src.hashCode();
        result = 31 * result + sink.hashCode();
        return result;
    }
}
