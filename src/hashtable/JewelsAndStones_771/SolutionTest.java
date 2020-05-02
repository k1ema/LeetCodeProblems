package hashtable.JewelsAndStones_771;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }
}