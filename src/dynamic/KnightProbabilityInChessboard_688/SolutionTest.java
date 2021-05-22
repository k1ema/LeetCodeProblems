package dynamic.KnightProbabilityInChessboard_688;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        double delta = 1e-5;
        assertEquals(0.0625, s.knightProbability(3, 2, 0, 0), delta);
        assertEquals(1.0, s.knightProbability(1, 0, 0, 0), delta);
        assertEquals(0.00093, s.knightProbability(5, 10, 0, 0), delta);
        assertEquals(0.00122, s.knightProbability(25, 100, 0, 0), delta);
    }
}