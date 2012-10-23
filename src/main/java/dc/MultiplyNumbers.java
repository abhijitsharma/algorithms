package dc;

import utils.BitUtils;

/**
 * User: absharma
 * Date: 5/31/12
 */
public class MultiplyNumbers {

    public int multiply(int x, int y) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int xb = BitUtils.countBits2(x);
        int yb = BitUtils.countBits2(y);
        int n = xb > yb ? xb : yb;
        System.out.println("n = " + n);
        int a = n / 2;

        int xl = BitUtils.firstN(x, a);
        int xr = BitUtils.lastN(x, a);
        int yl = BitUtils.firstN(y, a);
        int yr = BitUtils.lastN(y, a);

        System.out.println(xl + " : " + xr);
        System.out.println(yl + " : " + yr);

        int p1 = multiply(xl, yl);
//        int p2 = multiply(xr, yr);
//        int p3 = multiply(xl + yl, xr + yr);

        return 999;
    }


}
