package hashtable.FindTheDifference_389;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals('e', s.findTheDifference("abcd", "abcde"));
        assertEquals('e', s.findTheDifference("eeee", "eeeee"));
    }
}