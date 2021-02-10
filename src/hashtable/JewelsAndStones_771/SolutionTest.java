package hashtable.JewelsAndStones_771;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }
}