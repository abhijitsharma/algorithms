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

    public Vertex(String label) {
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public List<Edge> getIn() {
        return in;
    }

    public List<Edge> getOut() {
        return out;
    }

    @Override
    public String toString() {
        return "v{" +
                "'" + label + '\'' +
                '}';
    }
}