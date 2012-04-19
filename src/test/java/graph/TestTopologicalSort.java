package graph;

import org.junit.Test;

import java.util.List;

/**
 * User: absharma
 * Date: 4/19/12
 */
public class TestTopologicalSort {

    @Test
    public void testTopologicalSort() {
        String s = "5\n" +
                "2\n" +
                "4 1 2\n" +
                "5 4";
        processSpec(s);

        s = "9\n" +
                "5\n" +
                "2 1\n" +
                "5 2 1 4\n" +
                "3 2 7 \n" +
                "8 7\n" +
                "9 8 3";
        processSpec(s);

        s = "11\n" +
                "5\n" +
                "11 7 5\n" +
                "8 7 3\n" +
                "9 8 11\n" +
                "2 11\n" +
                "10 3 11\n";
        processSpec(s);

        s = "3\n" +
                "2\n" +
                "1 2 3\n" +
                "3 1\n";
        try {
            processSpec(s);
        } catch (Exception e) {
            System.out.println("Expected error : " + e.getMessage());
        }

        s = "2\n" +
                "2\n" +
                "1 2\n" +
                "2 1\n";
        try {
            processSpec(s);
        } catch (Exception e) {
            System.out.println("Expected error : " + e.getMessage());
        }

    }

    private void processSpec(String s) {
        TopologicalSort sort = new TopologicalSort();
        Graph graph = sort.createGraph(s);
//        System.out.println("graph = " + graph);

        List<Vertex> list = sort.sort(graph);
        for (Vertex v : list) {
            System.out.print(v.getLabel() + " ");
        }
        System.out.println();
    }

}
