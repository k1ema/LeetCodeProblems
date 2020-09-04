package greedy.PartitionLabels_763;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(6, 1), s.partitionLabels("abcabcd"));
        assertEquals(Arrays.asList(6, 6), s.partitionLabels("abcabcdefdef"));
        assertEquals(Arrays.asList(9, 7, 8), s.partitionLabels("ababcbacadefegdehijhklij"));
        assertEquals(Arrays.asList(9, 9), s.partitionLabels("abcabcabcdefdefdef"));
        assertEquals(Arrays.asList(10, 10, 1), s.partitionLabels("abchabcabcdefdefjdefl"));
        assertEquals(Arrays.asList(1, 9), s.partitionLabels("caedbdedda"));
    }
}
