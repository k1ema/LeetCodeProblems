package array.MaximizeDistanceToClosestPerson_849;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.maxDistToClosest(new int[] {1, 0, 0, 0, 1, 0, 1}));
        assertEquals(3, s.maxDistToClosest(new int[] {1, 0, 0, 0}));
        assertEquals(1, s.maxDistToClosest(new int[] {0, 1}));
    }
}