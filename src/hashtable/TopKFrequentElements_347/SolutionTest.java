package hashtable.TopKFrequentElements_347;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(1, 2), s.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
        assertEquals(Collections.singletonList(1), s.topKFrequent(new int[] {1}, 1));
        assertEquals(Collections.singletonList(0), s.topKFrequent(new int[] {3, 0, 1, 0}, 1));
    }
}
