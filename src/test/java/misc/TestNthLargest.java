package misc;

import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * User: absharma
 * Date: 5/11/12
 */
public class TestNthLargest {
    @Test
    public void testSolve() {
        String s;

//        s = "123\n" +
//                "2";
//
//        processSpec(s, "213");
//
//        s = "123\n" +
//                "5";
//
//        processSpec(s, "321");
//
//        s = "123\n" +
//                "6";
//
//        processSpec(s, "NONE");
//
//        s = "1234\n" +
//                "1";
//
//        processSpec(s, "1243");
//
//        s = "23146\n" +
//                "2";
//
//        processSpec(s, "23416");

//        s = "222\n" +
//                "1";
//
//        processSpec(s, "NONE");

//        s = "221\n" +
//                "1";
//
//        processSpec(s, "221");

        s = "1221\n" +
                "1";

        processSpec(s, "221");

    }

    private void processSpec(String s, String expected) {
        try {
            NthLargestRepeatedDigits nthLargest = new NthLargestRepeatedDigits();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));
            Scanner scanner = new Scanner(new BufferedInputStream(inputStream));
            scanner.useDelimiter("\n");
            String firstLine = scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            String out = nthLargest.getNth(firstLine, n);
//            Assert.assertEquals(expected, out.trim());
            System.out.println(out);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

}
