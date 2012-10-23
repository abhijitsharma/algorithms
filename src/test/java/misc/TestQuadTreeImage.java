package misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class TestQuadTreeImage {
    @Test
    public void testBasic() {
        test("ppeeefpffeefe", "pefepeefe", 640);
        test("ppeeefpffeefe", "e", 448);
        test("pffff", "pefepeefe", 1024);
        test("f", "pefepeefe", 1024);
        test("e", "pefepeefe", 320);
        test("e", "e", 0);
        test("f", "e", 1024);
        test("f", "f", 1024);
        test("pfffpeeef", "pfffpeeef", 832);
        test("pffpffpffffff", "peepeepeeeeee", 1024);
        test("pffpffpfffffe", "peepeepeeeeee", 768);
        test("pffpffpffffee", "peepeepeeeeee", 704);
        test("pffpffpffffee", "pffpeepeeeeee", 704);
    }

    private void test(String s1, String s2, int expected) {
        QuadTreeImage p = new QuadTreeImage();
        int b = p.process(s1, s2);
        Assert.assertEquals(expected, b);
        b = p.process(s2, s1); // reverse should also be true
        Assert.assertEquals(expected, b);
    }

}
