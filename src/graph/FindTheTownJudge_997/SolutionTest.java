package graph.FindTheTownJudge_997;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findJudge(2, new int[][] {{1, 2}}));
        assertEquals(3, s.findJudge(3, new int[][] {{1, 3}, {2, 3}}));
        assertEquals(-1, s.findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}}));
        assertEquals(-1, s.findJudge(3, new int[][] {{1, 2}, {2, 3}}));
        assertEquals(3, s.findJudge(4, new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
