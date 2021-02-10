package dynamic.NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_1269;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.numWays(3, 2));
        assertEquals(2, s.numWays(2, 4));
        assertEquals(8, s.numWays(4, 2));
        assertEquals(9, s.numWays(4, 3));
        assertEquals(525833932, s.numWays(430, 148488));
        assertEquals(374847123, s.numWays(500, 1000000));
    }
}