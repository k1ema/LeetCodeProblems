package array.FindAllDuplicatesInAnArray_442;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(3, 2), s.findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }
}