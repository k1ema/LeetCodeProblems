package string.MaximumScoreAfterSplittingAString_1422;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.maxScore("011101"));
        assertEquals(5, s.maxScore("00111"));
        assertEquals(3, s.maxScore("1111"));
    }
}