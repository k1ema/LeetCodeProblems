package array.BuildingsWithAnOceanView_1762;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {0,2,3}, s.findBuildings(new int[] {4,2,3,1}));
        assertArrayEquals(new int[] {0, 1,2,3}, s.findBuildings(new int[] {4,3,2,1}));
        assertArrayEquals(new int[] {3}, s.findBuildings(new int[] {1,3,2,4}));
        assertArrayEquals(new int[] {3}, s.findBuildings(new int[] {2,2,2,2}));
    }
}