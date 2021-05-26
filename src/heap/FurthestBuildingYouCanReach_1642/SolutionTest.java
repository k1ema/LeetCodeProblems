package heap.FurthestBuildingYouCanReach_1642;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1));
        assertEquals(7, s.furthestBuilding(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        assertEquals(3, s.furthestBuilding(new int[] {14, 3, 19, 3}, 17, 0));
        assertEquals(11, s.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12, 4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 3));
    }
}