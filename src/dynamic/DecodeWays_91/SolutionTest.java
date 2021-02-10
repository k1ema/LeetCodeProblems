package dynamic.DecodeWays_91;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.numDecodings("12"));
        assertEquals(3, s.numDecodings("123"));
        assertEquals(3, s.numDecodings("226"));
        assertEquals(5, s.numDecodings("1213"));
        assertEquals(1, s.numDecodings("102"));
        assertEquals(0, s.numDecodings("012"));
        assertEquals(2, s.numDecodings("31026"));
        assertEquals(1, s.numDecodings("27"));
        assertEquals(1769472,
                s.numDecodings("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"));
    }
}
