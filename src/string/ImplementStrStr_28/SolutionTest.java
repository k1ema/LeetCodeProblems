package string.ImplementStrStr_28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.strStr("hello", "ll"));
        assertEquals(-1, s.strStr("aaaaa", "bba"));
        assertEquals(0, s.strStr("", ""));
        assertEquals(0, s.strStr("a", ""));
        assertEquals(-1, s.strStr("aaa", "aaaa"));
        assertEquals(-1, s.strStr("jdksfhskjdfhsdkjaaa", "aaaa"));
        assertEquals(18, s.strStr("jdksfhsaaakjdfhsdkaaaaj", "aaaa"));
        assertEquals(1, s.strStr("mississippi", "issi"));
        assertEquals(92, s.strStr("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa"));
    }
}
