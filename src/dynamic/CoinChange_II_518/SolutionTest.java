package dynamic.CoinChange_II_518;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.change(5, new int[] {1, 2, 5}));
        assertEquals(0, s.change(3, new int[] {2}));
        assertEquals(1, s.change(10, new int[] {10}));
        assertEquals(1, s.change(0, new int[] {}));
        assertEquals(1, s.change(0, new int[] {7}));
        assertEquals(2, s.change(6, new int[] {2, 3}));
        assertEquals(12701, s.change(500, new int[] {1, 2, 5}));
    }
}
