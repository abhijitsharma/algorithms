package utils;

import java.util.List;

/**
 * User: absharma
 * Date: 3/28/12
 */
public final class Utils {

    public static boolean listEquals(List is, List js) {
        if(is == null && js == null) {
            return true;
        } else if(is == null) {
            return js.size() == 0;
        } else if(js == null) {
            return is.size() == 0;
        }
        return is.equals(js);
    }

    public static void printList(List is) {
        System.out.print("[");
        if(is != null) {
            for (Object o : is) {
                System.out.print(o + ", ");
            }
        }
        System.out.println("]");
    }
    
}
