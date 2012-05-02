package recursion.backtrack;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 * User: absharma
 * Date: 4/27/12
 */
public class TestSchedule {


    @Test
    public void testSchedule() throws Exception{
        String s = "5\n" +
                "1 4\n" +
                "2 3\n" +
                "1 5\n" +
                "3\n" +
                "3 5";
        testIt(s);

        s = "5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5";
        testIt(s);

        s = "5\n" +
                "5\n" +
                "4\n" +
                "3\n" +
                "2\n" +
                "1";
        testIt(s);

        s = "5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5\n" +
                "1\n" +
                "2";
        testIt(s);

        s = "5\n" +
                "5\n" +
                "3\n" +
                "1\n" +
                "4\n" +
                "2";
        testIt(s);

        s = "5\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5";
        try {
            testIt(s);
        } catch (IllegalStateException e) {
            System.out.println("No Solution");
        }
    }

    private void testIt(String s) throws UnsupportedEncodingException {
        Schedule schedule = new Schedule();
        int[][] taskDays = schedule.createData(new ByteArrayInputStream(s.getBytes("UTF-8")));
        int[] result = schedule.solve(taskDays);
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
