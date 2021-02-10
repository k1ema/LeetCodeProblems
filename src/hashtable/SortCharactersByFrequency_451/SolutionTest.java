package hashtable.SortCharactersByFrequency_451;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("eert", s.frequencySort("tree"));
        assertEquals("aaaccc", s.frequencySort("cccaaa"));
        assertEquals("bbAa", s.frequencySort("Aabb"));
    }
}