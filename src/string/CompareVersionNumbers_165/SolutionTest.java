package string.CompareVersionNumbers_165;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(-1, s.compareVersion("0.1", "1.1"));
        assertEquals(-1, s.compareVersion("1.0", "1.1"));
        assertEquals(1, s.compareVersion("1.0.1", "1"));
        assertEquals(-1, s.compareVersion("7.5.2.4", "7.5.3"));
        assertEquals(0, s.compareVersion("1.01", "1.001"));
        assertEquals(0, s.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, s.compareVersion("1.0", "1.2"));
    }
}