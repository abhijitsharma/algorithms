package permutations;

import java.util.ArrayList;
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
        for (String object : objects) {
            Integer count = available.get(object);
            if (count == null) {
                count = 0;
            }
            available.put(object, ++count);
        }
        Set<List<String>> results = new HashSet<List<String>>();
        _permute(null, objects, numSlots, new Stack<String>(), available, results, callback);
        return results;
    }

    private void _permute(
            String curr,
            List<String> objects,
            int numSlots,
            Stack<String> stack,
            Map<String, Integer> available,
            Set<List<String>> results,
            PermutationCallback callback) {
        indent += 4;

        if (curr != null) {
            Integer count = available.get(curr);
            available.put(curr, --count);
            stack.push(curr);
//            System.out.println(spaces(indent) + "_p " + curr + "[ " + available + "]");
        }

        boolean goOn = true;
        if (stack.size() == numSlots) { // found a solution
            List<String> solution = new ArrayList<String>(stack);
            if(callback != null)
                goOn = callback.call(solution);
            results.add(solution);
        }

        if(goOn)
            for (String j : objects) {
                Integer c = available.get(j);
                if (c > 0) {
                    _permute(j, objects, numSlots, stack, available, results, callback);
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
}
