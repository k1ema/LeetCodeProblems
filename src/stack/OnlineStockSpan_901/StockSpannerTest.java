package stack.OnlineStockSpan_901;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockSpannerTest {
    @Test
    public void test() {
        StockSpanner ss = new StockSpanner();
        assertEquals(1, ss.next(100));
        assertEquals(1, ss.next(80));
        assertEquals(1, ss.next(60));
        assertEquals(2, ss.next(70));
        assertEquals(1, ss.next(60));
        assertEquals(4, ss.next(75));
        assertEquals(6, ss.next(85));
    }
}
