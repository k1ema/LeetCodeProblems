package binarySearch.RandomPointInNonOverlappingRectangles_497;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution(new int[][] {{-2, -2, -1, -1}, {1, 0, 3, 0}});
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));
        System.out.println(Arrays.toString(s.pick()));
    }
}