package array.FindTheCelebrity_277;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution(new int[][] {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}});
        assertEquals(1, s.findCelebrity(3));

        s = new Solution(new int[][] {{1, 0, 1}, {1, 1, 0}, {0, 1, 1}});
        assertEquals(-1, s.findCelebrity(3));

        s = new Solution(new int[][] {{1, 0}, {0, 1}});
        assertEquals(-1, s.findCelebrity(2));
    }
}