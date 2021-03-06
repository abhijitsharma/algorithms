package misc;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * User: absharma
 * Date: 5/11/12
 */
public class TestExplosion {
    @Test
    public void testSolve() {
        String s;

        s = "5\n" +
                "0 4 6 9 13\n" +
                "3 4 2 0 7";

        processSpec(s, "5 5");

        s = "4\n" +
                "0 2 4 7\n" +
                "5 5 2 0";

        processSpec(s, "1 4\n2 4\n3 4");

        s = "4\n" +
                "0 2 4 6\n" +
                "2 2 2 2";

        processSpec(s, "1 4\n2 4\n3 4\n4 4");

        s = "4\n" +
                "0 2 4 6\n" +
                "10 10 10 10";

        processSpec(s, "1 4\n2 4\n3 4\n4 4");

        s = "4\n" +
                "0 4 8 12\n" +
                "2 2 2 2";

        processSpec(s, "1 1\n2 1\n3 1\n4 1");

        s = "3\n" +
                "0 1 50\n" +
                "500 1 20";

        processSpec(s, "1 3\n2 3");

        s = "5\n" +
                "1 10 11 19 20\n" +
                "8 1 11 1 1";

        processSpec(s, "2 5\n3 5");
        s = "6\n" +
                "1 10 11 18 19 20\n" +
                "8 1 11 1 1 1";

        processSpec(s, "2 6\n3 6");
    }

    private void processSpec(String s, String expected) {
//        System.out.println(s);
//        System.out.println();
//        System.out.println("==========");
        try {
            Explosion explosion = new Explosion();
            List<Explosion.Bird> birds = explosion.createRanges(new ByteArrayInputStream(s.getBytes("UTF-8")));
//            for (int i = 0; i < birds.size(); i++) {
//                Explosion.Bird bird = birds.get(i);
//                System.out.println(bird);
//            }
            StringBuilder sb = new StringBuilder();
            int[][] birdKills = explosion.process(birds);
//            System.out.println("----------");
//            for (int i = 0; i < birds.size(); i++) {
//                Explosion.Bird bird = birds.get(i);
//                System.out.println(bird);
//            }

            for (int[] bk : birdKills) {
                sb.append(bk[0]).append(" ").append(bk[1]);
                sb.append("\n");
            }
            Assert.assertEquals(expected, sb.toString().trim());
            System.out.println(sb.toString());
//            System.out.println("-------");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

}
