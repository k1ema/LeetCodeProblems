package dynamic.CountSortedVowelStrings_1641;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.countVowelStrings(1));
        assertEquals(15, s.countVowelStrings(2));
        assertEquals(66045, s.countVowelStrings(33));
    }
}