package tree.CountCompleteTreeNodes_222;

import org.junit.Test;

import tree.utils.Parser;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(10, s.countNodes1(Parser.parseData(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    }
}
