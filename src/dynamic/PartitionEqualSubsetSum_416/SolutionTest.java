package dynamic.PartitionEqualSubsetSum_416;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canPartition(new int[] {1, 5, 11, 5}));
        assertFalse(s.canPartition(new int[] {1, 2, 3, 5}));
        assertFalse(s.canPartition(new int[] {2, 2, 3, 5}));
    }
}
