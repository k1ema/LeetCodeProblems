package hashtable.BullsAndCows_299;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1A3B", s.getHint("1807", "7810"));
        assertEquals("1A1B", s.getHint("1123", "0111"));
        assertEquals("0A1B", s.getHint("1949", "4422"));
        assertEquals("3A15B", s.getHint("0029138450392845093485", "0234592387459873249025"));
    }
}