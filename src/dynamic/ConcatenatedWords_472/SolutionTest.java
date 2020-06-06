package dynamic.ConcatenatedWords_472;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("dogcatsdog", "catsdogcats", "ratcatdogcat"),
                s.findAllConcatenatedWordsInADict(new String[] {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
        assertEquals(new ArrayList<>(), s.findAllConcatenatedWordsInADict(new String[] {""}));
    }
}