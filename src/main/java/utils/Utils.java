package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
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
        System.out.print("]");
    }

    public static String readStream(String path) throws IOException {
        FileInputStream is = new FileInputStream(path);
        Writer writer = new StringWriter();

        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(
                    new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        return writer.toString();
    }

    public static String spaces(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
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
