package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class Graph {
    private Set<Edge> edges = new HashSet<Edge>();
    private List<Vertex> vertices = new ArrayList<Vertex>();
    private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addVertex(Vertex v) {
        vertexMap.put(v.label(), v);
        vertices.add(v);
    }

    public void removeVertex(Vertex v) {
        vertexMap.remove(v.label());
        vertices.remove(v);
    }

    public Set<Edge> edges() {
        return edges;
    }

    public List<Vertex> vertices() {
        return vertices;
    }

    public Vertex vertex(String label) {
        return vertexMap.get(label);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "edges=" + edges +
                ", vertices=" + vertices +
                '}';
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
        if(edge.directed()) {
            edge.v1().removeOut(edge);
            edge.v2().removeIn(edge);
        } else {
            edge.v1().removeEdge(edge);
            edge.v2().removeEdge(edge);
        }
    }

    public int numEdges() {
        return edges.size();
    }
}
