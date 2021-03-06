package string.ConsecutiveCharacters_1446;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.maxPower("leetcode"));
        assertEquals(5, s.maxPower("abbcccddddeeeeedcba"));
        assertEquals(5, s.maxPower("triplepillooooow"));
        assertEquals(11, s.maxPower("hooraaaaaaaaaaay"));
        assertEquals(1, s.maxPower("tourist"));
    }
}