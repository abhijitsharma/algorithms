package misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestContainer {
    @Test
    public void testBasic() {
        test("CBA", 1);
        test("CBACBA", 2);
    }

    private void test(String s1, int expected) {
        Container p = new Container();
        int b = p.process(s1);
        Assert.assertEquals(expected, b);
    }

}
