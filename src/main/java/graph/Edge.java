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
}
