package backtracking.LetterCasePermutation_784;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"), s.letterCasePermutation1("a1b2"));
        assertEquals(Arrays.asList("3z4", "3Z4"), s.letterCasePermutation("3z4"));
        assertEquals(Collections.singletonList("12345"), s.letterCasePermutation("12345"));
    }
}
