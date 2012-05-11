package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class Vertex {
    private String label;
    private List<Edge> in = new ArrayList<Edge>();
    private List<Edge> out = new ArrayList<Edge>();
    private List<Edge> adjacent = new ArrayList<Edge>();

    public Vertex(String label) {
        this.label = label;
    }

    public void addEdge(Edge e) {
        adjacent.add(e);
    }

    public void addIn(Edge e) {
        in.add(e);
    }

    public void addOut(Edge e) {
        out.add(e);
    }

    public void removeIn(Edge e) {
        in.remove(e);
    }

    public void removeOut(Edge e) {
        out.remove(e);
    }

    public void removeEdge(Edge e) {
        adjacent.remove(e);
    }

    public String label() {
        return label;
    }

    public List<Edge> inEdges() {
        return in;
    }

    public List<Edge> outEdges() {
        return out;
    }

    public List<Edge> adjacentEdges() {
        return adjacent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (!label.equals(vertex.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Vertex");
        sb.append("{label='").append(label).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
