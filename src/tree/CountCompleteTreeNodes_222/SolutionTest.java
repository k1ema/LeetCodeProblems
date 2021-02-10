package tree.CountCompleteTreeNodes_222;

import org.junit.jupiter.api.Test;
import tree.utils.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.countNodes(Parser.parseData(new Integer[] {1, 2, 3, 4, 5, 6})));
        assertEquals(10, s.countNodes(Parser.parseData(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    }
}
