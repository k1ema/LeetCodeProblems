package dynamic.ConcatenatedWords_472;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("catsdogcats", "dogcatsdog", "ratcatdogcat"),
                s.findAllConcatenatedWordsInADict(new String[] {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
        assertEquals(new ArrayList<>(), s.findAllConcatenatedWordsInADict(new String[] {""}));
    }
}