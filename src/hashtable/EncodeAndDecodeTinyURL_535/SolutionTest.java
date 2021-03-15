package hashtable.EncodeAndDecodeTinyURL_535;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        assertEquals(longUrl, s.decode(s.encode(longUrl)));
    }
}