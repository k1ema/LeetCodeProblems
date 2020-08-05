package hashtable.IsomorphicStrings_205;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isIsomorphic("egg", "add"));
        assertFalse(s.isIsomorphic("foo", "bar"));
        assertTrue(s.isIsomorphic("paper", "title"));
        assertTrue(s.isIsomorphic("ab", "ba"));
        assertFalse(s.isIsomorphic("ab", "aa"));
    }
}