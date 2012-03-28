package utils;

/**
 * User: absharma
 * Date: 3/28/12
 */
public final class Utils {

    public static boolean intArrayEquals(int[] is, int[] js) {
        if(is == null && js == null) {
            return true;
        } else if(is == null) {
            return false;
        } else if(js == null) {
            return false;
        }

        if(is.length != js.length) {
            return false;
        }
        int size = is.length;
        for (int i = 0; i < size; i++) {
            if(is[i] != js[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printIntArray(int[] is) {
        System.out.print("[");
        if(is != null) {
            int size = is.length;
            for (int i = 0; i < size; i++) {
                System.out.print(i + ", ");
            }
        }
        System.out.println("]");
    }
    
}
