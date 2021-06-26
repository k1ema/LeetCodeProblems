package dynamic.NumberOfWaysToPaintNx3Grid_1411;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(12, s.numOfWays(1));
        assertEquals(54, s.numOfWays(2));
        assertEquals(246, s.numOfWays(3));
        assertEquals(106494, s.numOfWays(7));
        assertEquals(30228214, s.numOfWays(5000));
    }
}