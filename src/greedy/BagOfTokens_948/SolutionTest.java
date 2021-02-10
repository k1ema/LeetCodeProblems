package greedy.BagOfTokens_948;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.bagOfTokensScore(new int[] {100}, 50));
        assertEquals(1, s.bagOfTokensScore(new int[] {100, 200}, 150));
        assertEquals(2, s.bagOfTokensScore(new int[] {100, 200, 300, 400}, 200));
        assertEquals(1, s.bagOfTokensScore(new int[] {83, 67, 0}, 49));
        assertEquals(2, s.bagOfTokensScore(new int[] {35, 18, 50, 3}, 10));
        assertEquals(6, s.bagOfTokensScore(new int[] {59, 0, 15, 33, 79, 72, 34, 62, 4, 16}, 99));
        assertEquals(4, s.bagOfTokensScore(new int[] {33, 41, 10, 91, 47, 84, 98, 34, 48, 70}, 43));
    }
}