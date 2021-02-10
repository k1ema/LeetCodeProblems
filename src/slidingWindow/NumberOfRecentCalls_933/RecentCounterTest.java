package slidingWindow.NumberOfRecentCalls_933;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecentCounterTest {
    @Test
    public void test() {
        RecentCounter r = new RecentCounter();
        assertEquals(1, r.ping(1));
        assertEquals(2, r.ping(100));
        assertEquals(3, r.ping(3001));
        assertEquals(3, r.ping(3002));
    }
}
