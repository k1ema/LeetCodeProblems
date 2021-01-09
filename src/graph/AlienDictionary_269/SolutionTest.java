package graph.AlienDictionary_269;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("wertf", s.alienOrder(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
        assertEquals("zx", s.alienOrder(new String[] {"z", "x"}));
        assertEquals("", s.alienOrder(new String[] {"z", "x", "z"}));
        assertEquals("", s.alienOrder(new String[] {"abc", "ab"}));
        assertEquals("acbz", s.alienOrder(new String[] {"ac", "ab", "zc", "zb"}));
    }
}