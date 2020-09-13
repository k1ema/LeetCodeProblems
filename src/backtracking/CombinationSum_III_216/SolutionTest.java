package backtracking.CombinationSum_III_216;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(Arrays.asList(1, 2, 4)), s.combinationSum3(3, 7));
        assertEquals(Arrays.asList(Arrays.asList(1, 2, 6), Arrays.asList(1, 3, 5), Arrays.asList(2, 3, 4)), s.combinationSum3(3, 9));
        assertEquals(Arrays.asList(Arrays.asList(1,2,9), Arrays.asList(1,3,8), Arrays.asList(1,4,7), Arrays.asList(1,5,6), Arrays.asList(2,3,7), Arrays.asList(2,4,6), Arrays.asList(3,4,5)),
                s.combinationSum3(3, 12));
        assertEquals(Arrays.asList(Arrays.asList(1,2,6,9), Arrays.asList(1,2,7,8), Arrays.asList(1,3,5,9), Arrays.asList(1,3,6,8), Arrays.asList(1,4,5,8), Arrays.asList(1,4,6,7), Arrays.asList(2,3,4,9), Arrays.asList(2,3,5,8), Arrays.asList(2,3,6,7), Arrays.asList(2,4,5,7), Arrays.asList(3,4,5,6)),
                s.combinationSum3(4, 18));
    }
}

