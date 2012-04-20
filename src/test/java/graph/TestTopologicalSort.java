package graph;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
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

        processSpec(s, "1 2 3 4 5");

        s = "9\n" +
                "5\n" +
                "2 1\n" +
                "5 2 1 4\n" +
                "3 2 7 \n" +
                "8 7\n" +
                "9 8 3";
        processSpec(s, "1 4 6 7 2 8 5 3 9");

        s = "11\n" +
                "5\n" +
                "11 7 5\n" +
                "8 7 3\n" +
                "9 8 11\n" +
                "2 11\n" +
                "10 3 11\n";
        processSpec(s, "1 3 4 5 6 7 11 8 2 10 9");

        s = "5\n" +
                "4\n" +
                "5 1 2 3 4\n" +
                "4 1 2 3\n" +
                "3 2 1\n" +
                "2 1\n";
        processSpec(s, "1 2 3 4 5");

        s = "3\n" +
                "2\n" +
                "1 2 3\n" +
                "2 3\n";
        processSpec(s, "3 2 1");

        s = "0\n" +
                "0\n";
        processSpec(s, "");

        s = "4\n" +
                "0\n";
        processSpec(s, "1 2 3 4");

        s = "3\n" +
                "2\n" +
                "1 2 3\n" +
                "3 1\n";
        try {
            processSpec(s, "");
        } catch (Exception e) {
            System.out.println("Expected error : " + e.getMessage());
        }

        s = "2\n" +
                "2\n" +
                "1 2\n" +
                "2 1\n";
        try {
            processSpec(s, "");
        } catch (Exception e) {
            System.out.println("Expected error : " + e.getMessage());
        }

    }

    private void processSpec(String s, String expected) {
        try {
            TopologicalSort sort = new TopologicalSort();
            Graph graph = sort.createGraph(new ByteArrayInputStream(s.getBytes("UTF-8")));
            StringBuilder sb = new StringBuilder();
            List<Vertex> list = sort.sort(graph);
            for (Vertex v : list) {
                sb.append(v.getLabel()).append(" ");
            }
            Assert.assertEquals(expected, sb.toString().trim());
            System.out.println(sb.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
