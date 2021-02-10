package dynamic.KnightDialer_935;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(10, s.knightDialer(1));
        assertEquals(20, s.knightDialer(2));
        assertEquals(104, s.knightDialer(4));
        assertEquals(136006598, s.knightDialer(3131));
    }
}