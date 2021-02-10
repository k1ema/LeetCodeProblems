package greedy.MeetingRooms_II_253;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.minMeetingRooms(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
        assertEquals(1, s.minMeetingRooms(new int[][] {{7, 10}, {2, 4}}));
        assertEquals(3, s.minMeetingRooms(new int[][] {{0, 1}, {0, 3}, {2, 5}, {4, 6}, {0, 7}, {8, 15}, {10, 12}}));
        assertEquals(0, s.minMeetingRooms(new int[][] {}));
        assertEquals(2, s.minMeetingRooms(new int[][] {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}));
    }
}