package backtracking.PartitionToKEqualSumSubsets_698;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4));
        assertTrue(s.canPartitionKSubsets(new int[] {129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22}, 3));
        assertFalse(s.canPartitionKSubsets(new int[] {2, 2, 2, 2, 3, 4, 5}, 4));
    }
}