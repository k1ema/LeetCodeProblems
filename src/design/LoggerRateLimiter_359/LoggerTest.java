package design.LoggerRateLimiter_359;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoggerTest {
    @Test
    public void test() {
        Logger l = new Logger();
        assertTrue(l.shouldPrintMessage(1, "foo"));
        assertTrue(l.shouldPrintMessage(2, "bar"));
        assertFalse(l.shouldPrintMessage(3, "foo"));
        assertFalse(l.shouldPrintMessage(8, "bar"));
        assertFalse(l.shouldPrintMessage(10, "foo"));
        assertTrue(l.shouldPrintMessage(11, "foo"));
    }
}