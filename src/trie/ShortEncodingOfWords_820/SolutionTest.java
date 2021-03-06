package trie.ShortEncodingOfWords_820;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(10, s.minimumLengthEncoding(new String[] {"time", "me", "bell"}));
        assertEquals(2, s.minimumLengthEncoding(new String[] {"t"}));
        assertEquals(18, s.minimumLengthEncoding(new String[] {"ga", "cba", "feda", "eda", "iheda"}));
    }
}