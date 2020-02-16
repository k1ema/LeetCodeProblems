package backtracking.WordSearch_79;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        assertTrue(s.exist(board, "ABCCED"));
        assertTrue(s.exist(board, "SEE"));
        assertFalse(s.exist(board, "ABCB"));

        board = new char[][] {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        assertFalse(s.exist(board, "aaaaaaaaaaaaa"));

        board = new char[][] {{'a', 'a'}, {'a', 'a'}};
        assertFalse(s.exist(board, "aaaaa"));

        board = new char[][] {{'a', 'b'}, {'c', 'd'}};
        assertTrue(s.exist(board, "acdb"));

        board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        assertTrue(s.exist(board, "ABCESEEEFS"));
    }
}
