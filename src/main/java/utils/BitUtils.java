package utils;

/**
 * User: absharma
 * Date: 5/31/12
 */
public final class BitUtils {

    public static int genNOnes(int n) {
        return (1 << n) - 1;
    }

    public static int firstN(int x, int n) {
        return x >>> n;
    }

    public static int lastN(int x, int n) {
        return x & genNOnes(n);
    }

    public static int countBits(int x) {
        int num = 0;
        do {
            x >>>= 1;
            num++;
        } while (x != 0);
        return num;
    }

    public static int countBits2(int x) {
        return 32 - Integer.numberOfLeadingZeros(x);
    }
}
