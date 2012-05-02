package graph;

import utils.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class TopologicalSort {

    public List<Vertex> sort(Graph graph) {
        List<Vertex> result = new ArrayList<Vertex>();

        List<Vertex> list = new ArrayList<Vertex>();
        for (Vertex v : graph.getVertices()) {
            if (v.getIn().size() == 0) { // add vertices with no incoming edges to exploration list
                list.add(v);
            }
        }

        while (!list.isEmpty()) {
            Vertex v = list.remove(0);// remove an element as all dependencies of this v are resolved (in = 0)
            result.add(v); // add to result
            for (Edge out : v.getOut()) { // consider all outgoing edges
                Vertex sink = out.getV2();
                sink.removeIn(out); // remove this edge from v's incoming edges
                graph.removeEdge(out); // remove edge from graph
                if (sink.getIn().size() == 0) { // if vertex now has no incoming add to exploration list
                    list.add(sink);
                }
            }
        }

        if (graph.numEdges() != 0) { // all edges should have been removed
            throw new IllegalStateException("There is a cycle ...");
        }
        
        return result;
    }

    public static void main(String[] args) {
        TopologicalSort sort = new TopologicalSort();
        List<Vertex> list = sort.sort(sort.createGraph(System.in));
        for (Vertex v : list) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }

    //todo DFS solution


    public Graph createGraph(InputStream in) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        scanner.useDelimiter("\n");

        int nv = Integer.parseInt(Utils.getLine(scanner));
        for (int i = 1; i <= nv; i++) {
            Vertex v = new Vertex("" + i);
            graph.addVertex(v);
        }

        int d = Integer.parseInt(Utils.getLine(scanner));
        for (int i = 0; i < d; i++) {
            String line = Utils.getLine(scanner);
            processLine(graph, line);
        }
        return graph;
    }

    private void processLine(Graph graph, String line) {
        String[] segs = line.split(" ");
        Vertex sink = graph.getVertex(segs[0]);
        for (int j = 1; j < segs.length; j++) {
            Vertex source = graph.getVertex(segs[j]);
            Edge edge = new Edge(source, sink);
            graph.addEdge(edge);
        }
    }
}
