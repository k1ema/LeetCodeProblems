package dynamic.CampusBikes_II_1066;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(6, s.assignBikes(new int[][] {{0, 0}, {2, 1}}, new int[][] {{1, 2}, {3, 3}}));
        assertEquals(4, s.assignBikes(new int[][] {{0, 0}, {1, 1}, {2, 0}}, new int[][] {{1, 0}, {2, 2}, {2, 1}}));
        assertEquals(4995, s.assignBikes(new int[][] {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
                new int[][] {{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}}));
        assertEquals(3320, s.assignBikes(new int[][] {{460, 458}, {596, 615}, {901, 893}, {456, 247}, {690, 492}, {229, 149}, {74, 792}, {566, 205}, {660, 559}, {955, 855}},
                new int[][] {{272, 92}, {316, 205}, {281, 371}, {938, 433}, {218, 310}, {510, 853}, {365, 626}, {416, 168}, {365, 258}, {577, 936}}));
    }
}
