package dynamic.MaximalSquare_221;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maximalSquare(new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
        assertEquals(16, s.maximalSquare(new char[][] {
                {'1', '0', '1', '0', '0', '0'},
                {'1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1'}
        }));
        assertEquals(9, s.maximalSquare(new char[][] {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
        }));
        assertEquals(1, s.maximalSquare(new char[][] {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0'},
        }));
        assertEquals(1, s.maximalSquare(new char[][] {
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'},
        }));
        assertEquals(16, s.maximalSquare(new char[][] {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
        }));
        assertEquals(1, s.maximalSquare(new char[][] {
                {'1'},
        }));
    }
}