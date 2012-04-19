package graph;

import java.io.BufferedInputStream;
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
            if (v.getIn().size() == 0) {
                list.add(v);
            }
        }

        while (!list.isEmpty()) {
            Vertex v = list.remove(0);// remove an element
            result.add(v); // add to result
            for (Edge out : v.getOut()) { // consider all outgoing edges
                Vertex sink = out.getSink();
                sink.removeIn(out); // remove this edge for incoming edges
                graph.removeEdge(out);
                if (sink.getIn().size() == 0) { // if vertex now has no incoming add to exploration list
                    list.add(sink);
                }
            }
        }
        if (graph.getEdges().size() != 0) {
            throw new IllegalStateException("There is a cycle ...");
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        String s = processInput();
        TopologicalSort sort = new TopologicalSort();
        List<Vertex> list = sort.sort(sort.createGraph(s));
        for (Vertex v : list) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }

    private static String processInput() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            scanner.useDelimiter("\n");

            String line;
            while(scanner.hasNext()) {
                line = scanner.nextLine();
                if(line.trim().length() == 0)
                    break;
                sb.append(line).append("\n");
            }
        } finally {
            scanner.close();
        }
        return sb.toString();
    }


    public Graph createGraph(String s) {
        Graph graph = new Graph();
        String[] lines = s.split("\n");
        int nv = Integer.parseInt(lines[0]);
        for (int i = 1; i <= nv; i++) {
            Vertex v = new Vertex("" + i);
            graph.addVertex(v);
        }

        int d = Integer.parseInt(lines[1]);
        for (int i = 0; i < d; i++) {
            String line = lines[2 + i];
            String[] segs = line.split(" ");
            Vertex sink = graph.getVertex(segs[0]);
            for (int j = 1; j < segs.length; j++) {
                Vertex source = graph.getVertex(segs[j]);
                Edge edge = new Edge(source, sink);
                graph.addEdge(edge);
            }
        }
        return graph;
    }
}
