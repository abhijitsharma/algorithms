package dc;

import org.junit.Test;
import utils.BitUtils;

/**
 * User: absharma
 * Date: 5/31/12
 */
public class TestMultiplyNumbers {

    @Test
    public void testMultiply() {
        // K&(1<<N)-1
        MultiplyNumbers mn = new MultiplyNumbers();
        // 182 * 182
        // 10110110 * 10110110

        // 211 * 89
        // 11010011 * 01011001
//        mn.multiply(6, 6);
        int n = 6;
        System.out.println("n = " + n + ":" + Integer.toBinaryString(n));
        int f = BitUtils.firstN(n, 2);
        System.out.println("f = " + f + ":" + Integer.toBinaryString(f));
        int g = BitUtils.lastN(n, 2);
        System.out.println("g = " + g + ":" + Integer.toBinaryString(g));
    }
}
