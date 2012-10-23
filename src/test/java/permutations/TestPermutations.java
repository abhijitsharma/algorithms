package permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * User: absharma
 * Date: 6/14/12
 */
public class TestPermutations {

    @Test
    public void testSolve() throws Exception{
        Permutations perms = new Permutations();
        Set<List<String>> results = perms.permute2(Arrays.asList("1", "2", "3"), 3);
        for(List<String> result : results) {
            for(String s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
