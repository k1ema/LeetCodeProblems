package array.CountLargestGroup_1399;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.countLargestGroup(13));
        assertEquals(2, s.countLargestGroup(2));
        assertEquals(6, s.countLargestGroup(15));
        assertEquals(5, s.countLargestGroup(24));
    }
}