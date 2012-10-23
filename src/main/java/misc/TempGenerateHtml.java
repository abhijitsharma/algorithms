package misc;

import utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * User: absharma
 * Date: 6/28/12
 */
public class TempGenerateHtml {
    private Random random = new Random();
    public static void main(String[] args) throws Exception {
        TempGenerateHtml generateHtml = new TempGenerateHtml();
        String path = "E:\\docs\\ninja\\lateral\\listq.txt";
        String content = Utils.readStream(path);
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String hc = generateHtml.generateHtmlContent(line, lines.length);
            String file = "e:\\cygwin\\tmp\\junk\\generate\\" + i + ".html";
            System.out.println("Dumping to file " + file);
            File f = new File(file);
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(hc.getBytes("UTF-8"));
            fos.close();
        }
    }

    private String generateHtmlContent(String line, int numLines) {
        int indent = 4;
        StringBuilder sb = new StringBuilder();
        sb.append("<html>").append("\n");
        sb.append(Utils.spaces(indent)).append("<body>").append("\n");
        sb.append(Utils.spaces(2 * indent)).append("<h4>").append("Choose option that is best associated with the statement below:").append("</h4>").append("\n");
        sb.append(Utils.spaces(2 * indent)).append(line.substring(0, 1).toUpperCase() + line.substring(1)).append("\n");
        String[] options = optionSets[random.nextInt(optionSets.length)];
        for (String option : options) {
            sb.append(generateOptionLink(3 * indent, random.nextInt(numLines), option));
        }
        sb.append(Utils.spaces(4)).append("</body>").append("\n");
        sb.append("</html>").append("\n");
        return sb.toString();
    }

    private String generateOptionLink(int indent, int fileNo, String option) {
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.spaces(indent)).append("<li>").append("\n");
        sb.append(Utils.spaces(indent + 4));
        sb.append("<a href=\"").append(fileNo).append(".html").append("\">").append(option).append("</a>").append("\n");
        sb.append(Utils.spaces(indent)).append("</li>").append("\n");
        return sb.toString();
    }

    private static final String[][] optionSets = new String[][]{
            {
                    "Ecstatic",
                    "Happy",
                    "Sad"
            },
            {
                    "Whale",
                    "Shark",
                    "Salmon"
            },
            {
                    "Sea",
                    "Ocean",
                    "Bay"
            },
            {
                    "Ship",
                    "Boat",
                    "Sail",
            },
            {
                    "Man",
                    "Woman",
                    "Child"
            },
            {
                    "Knives",
                    "Swords",
                    "Bows"
            },
            {
                    "Story",
                    "Classic",
                    "Narrative"
            },
            {
                    "Jacket",
                    "Skirt",
                    "Trousers"
            },
            {
                    "Adoloscence",
                    "Boyhood",
                    "Infancy"
            },
            {
                    "Pierce",
                    "Cut",
                    "Stab"
            },
            {
                    "Voyage",
                    "Journey",
                    "Sojourn"
            },
            {
                    "Belief",
                    "Philosophy",
                    "Thoughts"
            },
            {
                    "Midnight",
                    "Noon",
                    "Dawn"
            },
            {
                    "Starbuck",
                    "Eagle",
                    "Vulture"
            },
            {
                    "Stroke",
                    "Palpitation",
                    "Murmur"
            },
            {
                    "Sun",
                    "Moon",
                    "Star"
            },
            {
                    "Quick",
                    "Lethargic",
                    "Glacial"
            },

    };


}
