package dynamic.CountVowelsPermutation_1220;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.countVowelPermutation(1));
        assertEquals(10, s.countVowelPermutation(2));
        assertEquals(68, s.countVowelPermutation(5));
    }
}