package string.MaxDifferenceYouCanGetFromChangingAnInteger_1432;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(888, s.maxDiff(555));
        assertEquals(8, s.maxDiff(9));
        assertEquals(820000, s.maxDiff(123456));
        assertEquals(80000, s.maxDiff(10000));
        assertEquals(8700, s.maxDiff(9288));
    }
}