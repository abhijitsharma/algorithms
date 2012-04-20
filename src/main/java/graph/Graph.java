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
        vertexMap.put(v.getLabel(), v);
        vertices.add(v);
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getVertex(String label) {
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
    }

    public int numEdges() {
        return edges.size();
    }
}
