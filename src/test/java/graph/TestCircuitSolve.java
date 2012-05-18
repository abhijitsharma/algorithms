package graph;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * User: absharma
 * Date: 5/11/12
 */
public class TestCircuitSolve {
    @Test
    public void testSolve() {
        String s;

        // Pure Serial
        s = "2 a c\n" +
                "a b 2\n" +
                "b c 2";

        processSpec(s, "a c 4.0", 1, true);

        s = "3 a d\n" +
                "a b 2\n" +
                "b c 3\n" +
                "c d 4";

        processSpec(s, "a d 9.0", 1, true);

        s = "4 a e\n" +
                "a b 2\n" +
                "b c 3\n" +
                "c d 4\n" +
                "d e 7";

        processSpec(s, "a e 16.0", 1, true);

        // Pure Parallel
        s = "2 a b\n" +
                "a b 2\n" +
                "a b 2";

        processSpec(s, "a b 1.0", 1, true);

        s = "3 a b\n" +
                "a b 5\n" +
                "a b 5\n" +
                "a b 5";

        processSpec(s, "a b 1.6666666", 1, true);

        // Nested Parallel
        s = "6 a c\n" +
                "a b 2\n" +
                "b c 2\n" +
                "b c 2\n" +
                "a d 2\n" +
                "d c 2\n" +
                "d c 2";

        processSpec(s, "a c 1.5", 1, true);

        // 2 Pure Parallel in series
        s = "4 a c\n" +
                "a b 2\n" +
                "a b 2\n" +
                "b c 2\n" +
                "b c 2";

        processSpec(s, "a c 2.0", 1, true);


        // Series + Parallel
        s = "4 a d\n" +
                "a b 2\n" +
                "b c 2\n" +
                "c d 2\n" +
                "c d 2";

        processSpec(s, "a d 5.0", 1, true);

        // 2 series in Parallel
        s = "4 a d\n" +
                "a b 2\n" +
                "b d 3\n" +
                "a c 4\n" +
                "c d 7";

        processSpec(s, "a d 3.4374998", 1, true);

        // 3 series in parallel
        s = "6 a f\n" +
                "a b 2\n" +
                "b c 2\n" +
                "c f 0\n" +
                "a d 2\n" +
                "d e 2\n" +
                "e f 0\n"
        ;

        processSpec(s, "a f 2.0", 1, true);

        System.out.println("----");
        s = "6 a b\n" +
                "a e 2\n" +
                "e b 2\n" +
                "a c 0\n" +
                "c d 8\n" +
                "c d 8\n" +
                "d b 0";

        processSpec(s, "a b 2.0", 1, true);

        s = "6 a c\n" +
                "a b 2\n" +
                "b c 2\n" +
                "a d 2\n" +
                "d c 2\n" +
                "a c 2\n" +
                "b d 2";

        processSpec(s, "a b 2.0", 6, false);

        s = "5 a d\n" +
                "a b 2\n" +
                "b d 2\n" +
                "a d 2\n" +
                "a c 2\n" +
                "c d 2";

        processSpec(s, "a d 1.0", 1, true);
    }

    private void processSpec(String s, String expected, int numEdges, boolean checkString) {
        try {
            CircuitSolve solve = new CircuitSolve();
            String[] labels = new String[2];
            Graph graph = solve.createGraph(new ByteArrayInputStream(s.getBytes("UTF-8")), labels);
            Vertex start = graph.vertex(labels[0]);
            StringBuilder sb = new StringBuilder();
            graph = solve.solve(graph);
            for (Edge e : graph.edges()) {
                sb.append(e.v1().label()).append(" ").append(e.v2().label()).append(" ").append(e.weight());
//                sb.append("\n" + e.label() + "\n");
                sb.append("\n");
            }
            if(checkString) {
                Assert.assertEquals(expected, sb.toString().trim());
            }
            Assert.assertEquals(numEdges, graph.numEdges());
            System.out.println(sb.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
