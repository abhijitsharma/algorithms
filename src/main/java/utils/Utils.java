package utils;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

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

    public static String processInput() {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        scanner.useDelimiter("\n");
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while(scanner.hasNext()) {
                line = scanner.nextLine();
                if(line.trim().length() == 0)
                    break;
                sb.append(line).append("\n");
            }
        } finally {
            scanner.close();
        }
        return sb.toString();
    }

    public static String getLine(Scanner scanner) {
        return scanner.nextLine();
    }

}
