package greedy.SmallestStringWithAGivenNumericValue_1663;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("aay", s.getSmallestString(3, 27));
        assertEquals("aaszz", s.getSmallestString(5, 73));
        assertEquals("aaaaaaszzz", s.getSmallestString(10, 103));
        assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz", s.getSmallestString(100, 1030));
    }
}