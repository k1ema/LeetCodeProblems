package dynamic.StoneGame_IV_1510;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.winnerSquareGame(1));
        assertFalse(s.winnerSquareGame(2));
        assertTrue(s.winnerSquareGame(3));
        assertTrue(s.winnerSquareGame(4));
        assertFalse(s.winnerSquareGame(7));
        assertTrue(s.winnerSquareGame(8));
        assertTrue(s.winnerSquareGame(9));
        assertFalse(s.winnerSquareGame(17));
    }
}