package unionFind.NumberOfIslands_200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
//        assertEquals(1, s.numIslands(new char[][] {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'},
//        }));
//        assertEquals(3, s.numIslands(new char[][] {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'},
//        }));
//        assertEquals(3, s.numIslands(new char[][] {
//                {'1', '0', '1', '1', '0', '1', '1'},
//        }));
        assertEquals(1, s.numIslands(new char[][] {{'1'}}));
    }
}
