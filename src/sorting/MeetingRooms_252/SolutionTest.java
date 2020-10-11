package sorting.MeetingRooms_252;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.canAttendMeetings(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
        assertTrue(s.canAttendMeetings(new int[][] {{7, 10}, {2, 4}}));
    }
}