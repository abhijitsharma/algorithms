package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class Permutations {

    private int indent = 0;

    public Set<List<String>> permute(List<String> objects, int numSlots) {
        return permute(objects, numSlots, null);
    }

    public Set<List<String>> permute(List<String> objects, int numSlots, PermutationCallback callback) {
        Map<String, Integer> available = new HashMap<String, Integer>();
        Set<String> unique = new HashSet<String>();
        for (String object : objects) {
            Integer count = available.get(object);
            if (count == null) {
                count = 0;
            }
            unique.add(object);
            available.put(object, ++count);
        }
        Set<List<String>> results = new HashSet<List<String>>();
        _permute(null,
                new ArrayList<String>(unique),
                numSlots,
                new Stack<String>(),
                available,
                results,
                callback,
                Arrays.asList(true));
        return results;
    }

    private void _permute(
            String curr,
            List<String> objects,
            int numSlots,
            Stack<String> stack,
            Map<String, Integer> available,
            Set<List<String>> results,
            PermutationCallback callback, List<Boolean> boolHolder) {
        indent += 4;
        boolean goOn = boolHolder.get(0);
        if (curr != null) {
            Integer count = available.get(curr);
            available.put(curr, --count);
            stack.push(curr);
//            System.out.println(spaces(indent) + "_p " + curr + "[ " + available + "]");
        }

        if (stack.size() == numSlots) { // found a solution
            List<String> solution = new ArrayList<String>(stack);
            if (callback != null) {
                if (goOn) {
                    goOn = callback.call(solution);
                    boolHolder.set(0, goOn);
                }

            }
            results.add(solution);
        }

        if (goOn)
            for (String j : objects) {
                Integer c = available.get(j);
                if (c > 0) {
                    _permute(j, objects, numSlots, stack, available, results, callback, boolHolder);
                }
            }

        if (curr != null) {
            Integer count = available.get(curr);
            available.put(curr, ++count);
        }
        if (!stack.empty())
            stack.pop();
        indent -= 4;
    }


    private String spaces(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public interface PermutationCallback {
        boolean call(List<String> solution);
    }

    public Set<List<String>> permute2(final List<String> objects, int numSlots) {
        Set<List<String>> results = new HashSet<List<String>>();
        _permute2(objects, new ArrayList<String>(objects), new Stack<String>(), results, numSlots);
        return results;
    }

    private int _permute2(List<String> all,
                          List<String> objects,
                          Stack<String> stack,
                          Set<List<String>> results,
                          int numSlots) {
        int cnt = 0;
        indent += 4;
        if (objects.size() == 0) {
            return cnt;
        }
        String first = objects.get(0);
        stack.push(first);
        cnt++;
        List<String> rest = new ArrayList<String>();
        for (int i = 1; i < objects.size(); i++) {
            rest.add(objects.get(i));
        }
        System.out.print(spaces(indent) + first);

        if (rest.size() == 1) {
            String e = rest.get(0);
            System.out.print(" " + e);
            stack.push(e);
            results.add(new ArrayList<String>(stack));
            cnt++;
        }
        System.out.println();

        for (String obj : all) {
            if (rest.size() > 1) {
                int n = _permute2(all, rest, stack, results, numSlots);
                while (--n >= 0) {
                    stack.pop();
                }
            }
        }
        indent -= 4;
        return cnt;
    }

}
