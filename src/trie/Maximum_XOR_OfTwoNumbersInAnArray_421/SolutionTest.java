package trie.Maximum_XOR_OfTwoNumbersInAnArray_421;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(28, s.findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
        assertEquals(62, s.findMaximumXOR(new int[] {32, 18, 33, 42, 29, 20, 26, 36, 15, 46}));
    }
}