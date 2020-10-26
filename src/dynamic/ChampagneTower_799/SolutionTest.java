package dynamic.ChampagneTower_799;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0.0, s.champagneTower(1,1,1), 1e-5);
        assertEquals(0.5, s.champagneTower(2,1,1), 1e-5);
        assertEquals(0.25, s.champagneTower(4,2,0), 1e-5);
        assertEquals(0.5, s.champagneTower(4,2,1), 1e-5);
        assertEquals(0.25, s.champagneTower(4,2,2), 1e-5);
        assertEquals(0.375, s.champagneTower(10,3,0), 1e-5);
        assertEquals(0.375, s.champagneTower(10,3,3), 1e-5);
        assertEquals(1.0, s.champagneTower(10,3,1), 1e-5);
        assertEquals(1.0, s.champagneTower(10,3,2), 1e-5);
        assertEquals(1.0, s.champagneTower(100000009,33,17), 1e-5);
    }
}