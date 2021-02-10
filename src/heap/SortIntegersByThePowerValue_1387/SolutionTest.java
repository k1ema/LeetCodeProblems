package heap.SortIntegersByThePowerValue_1387;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(13, s.getKth(12, 15, 2));
        assertEquals(1, s.getKth(1, 1, 1));
        assertEquals(7, s.getKth(7, 11, 4));
        assertEquals(13, s.getKth(10, 20, 5));
        assertEquals(570, s.getKth(1, 1000, 777));
    }
}