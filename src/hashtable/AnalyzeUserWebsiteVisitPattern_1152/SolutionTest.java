package hashtable.AnalyzeUserWebsiteVisitPattern_1152;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(Arrays.asList("home", "about", "career"), s.mostVisitedPattern(
                new String[] {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
                new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                new String[] {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"}));

        assertEquals(Arrays.asList("a", "b", "a"), s.mostVisitedPattern(
                new String[] {"u1", "u1", "u1", "u2", "u2", "u2"},
                new int[] {1, 2, 3, 4, 5, 6},
                new String[] {"a", "b", "a", "a", "b", "c"}));
    }
}
