package sorting.ContainsDuplicate_III_220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 1}, 3, 0));
        assertTrue(s.containsNearbyAlmostDuplicate(new int[] {1, 0, 1, 1}, 1, 2));
        assertFalse(s.containsNearbyAlmostDuplicate(new int[] {1, 5, 9, 1, 5, 9}, 2, 3));
        assertTrue(s.containsNearbyAlmostDuplicate(new int[] {3, 6, 0, 4}, 2, 2));
        assertFalse(s.containsNearbyAlmostDuplicate(new int[] {-1, 2147483647}, 1, 2147483647));
        assertTrue(s.containsNearbyAlmostDuplicate(new int[] {2147483645, 2147483647}, 1, 3));
    }
}