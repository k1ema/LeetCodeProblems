package slidingWindow.NumberOfRecentCalls_933;

import org.junit.Assert;
import org.junit.Test;

public class RecentCounterTest {
    @Test
    public void test() {
        RecentCounter r = new RecentCounter();
        Assert.assertEquals(1, r.ping(1));
        Assert.assertEquals(2, r.ping(100));
        Assert.assertEquals(3, r.ping(3001));
        Assert.assertEquals(3, r.ping(3002));
    }
}
