package binarySearch.Heaters_475;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.findRadius(new int[] {1, 2, 3}, new int[] {2}));
        assertEquals(1, s.findRadius(new int[] {1, 2, 3, 4}, new int[] {1, 4}));
        assertEquals(3, s.findRadius(new int[] {1, 2, 4, 5}, new int[] {4}));
        assertEquals(161834419, s.findRadius(new int[] {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[] {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }
}
