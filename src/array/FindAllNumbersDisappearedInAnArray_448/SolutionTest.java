package array.FindAllNumbersDisappearedInAnArray_448;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(5, 6), s.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }
}