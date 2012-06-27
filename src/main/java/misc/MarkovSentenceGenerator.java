package misc;

import utils.Utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * User: absharma
 * Date: 6/27/12
 */
public class MarkovSentenceGenerator {

    public static void main(String[] args) throws Exception {
        int totalWords = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        Chain chain = new Chain(2, totalWords);
        String s = Utils.readStream("E:\\nltk_data\\corpora\\gutenberg\\melville-moby_dick.txt");
        chain.build(s);
        chain.generate();
    }
}

class Chain {
    private int numWords = 2;
    private int totalWords = 100;
    public static final String NON_WORD = "\n";
    private Random rand = new Random();
    private Map<Prefix, List<String>> stateMap = new HashMap<Prefix, List<String>>();
    private Prefix curr;

    Chain(int numWords, int totalWords) {
        this.numWords = numWords;
        this.totalWords = totalWords;
        curr = new Prefix(numWords, NON_WORD);
    }

    void addWord(String word) {
        List<String> suffix = stateMap.get(curr);
        if (suffix == null) {
            suffix = new ArrayList<String>();
        }
        suffix.add(word);
        stateMap.put(new Prefix(curr), suffix);
        curr.getWords().remove(0);
        curr.getWords().add(word);
    }

    void build(String s) {
        String[] parts = s.split(" ");
        for (String part : parts) {
            addWord(part.toLowerCase());
        }
        addWord(NON_WORD);
    }

    public void generate() {
        curr = new Prefix(numWords, NON_WORD);
        for (int i = 0; i <= totalWords; i++) {
            List<String> suffix = stateMap.get(curr);
            int r = Math.abs(rand.nextInt()) % suffix.size();
            String chosenSuffix = suffix.get(r);
            if (chosenSuffix.equals(NON_WORD))
                break;
            System.out.println(chosenSuffix);
            curr.getWords().remove(0);
            curr.getWords().add(chosenSuffix);
        }
    }
}

class Prefix {
    private int numWords = 2;
    private List<String> words = new ArrayList<String>();

    Prefix(Prefix prefix) {
        numWords = prefix.numWords;
        words.addAll(prefix.getWords());
    }

    Prefix(int numWords, String word) {
        this.numWords = numWords;
        int i = 0;
        while (i++ < numWords)
            addWord(word);
    }

    void addWord(String word) {
        if (words.size() == numWords) {
            throw new RuntimeException("Prefix already has max words " + numWords);
        }
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prefix prefix = (Prefix) o;

        if (numWords != prefix.numWords) return false;
        if (!words.equals(prefix.words)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numWords;
        result = 31 * result + words.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Prefix{" +
                "numWords=" + numWords +
                ", words=" + words +
                '}';
    }
}
